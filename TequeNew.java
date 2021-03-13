import java.util.*;
import java.io.*;

public class TequeNew {

    public static void main(String args[]) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(reader.readLine());
        Teque teque = new Teque();
        int length = 0;
        boolean large = false;

        if (number > 10000) {
            large = true;
        }

        while(number > 0) {
            number--;
            String[] input = reader.readLine().split(" ");
            length = input[0].length();
            
            if (length == 9) {
                teque.addLast(input[1]);
            } else if (length == 10) {
                teque.addFirst(input[1]);
            } else if (length == 11) {
                teque.addMiddle(input[1]);
            } else {
                writer.write(teque.get(Integer.parseInt(input[1])));
                writer.newLine();
            }
        }
        writer.flush();
    }

    private static class Teque {
        LinkedList<String> first;
        LinkedList<String> second;

        public Teque() {
            first = new LinkedList<>();
            second = new LinkedList<>();
        }

        public void addFirst(String newElement) {
            if (first.size() > second.size()) {
                second.addFirst(first.removeLast());
            }
            first.addFirst(newElement);
        }

        public void addLast(String newElement) {
            second.addLast(newElement);
            if (second.size() > first.size()) {
                first.addLast(second.removeFirst());
            }
        }

        public void addMiddle(String newElement) {
            if (first.size() == second.size()) {
                first.addLast(newElement);
            } else {
                second.addFirst(newElement);
                if (second.size() > first.size()) {
                    first.addLast(second.removeFirst());
                }
            }
        }

        public String get(int index) {
            String result;
            if (index < first.size()) {
                result = first.get(index);
            } else {
                index = index - first.size();
                result = second.get(index);
            }
            return result;
        }

    }
}