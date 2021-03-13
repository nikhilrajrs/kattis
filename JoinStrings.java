import java.util.*;
import java.io.*;

public class JoinStrings {

    public static void main(String args[]) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        if (number == 1) {
            System.out.println(reader.readLine());
            return;
        }
            Map<String, CustomString> strings = new HashMap<>(number + 10, 1);
            String lastKey = null, key2 = null;
            String[] operation = null;
            CustomString temp = null;
            int totalLength = 0;
            
            for (int i = 1; i <= number; i++) {
                temp = new CustomString(reader.readLine());
                strings.put(Integer.toString(i), temp);
                totalLength += temp.content.length;
            }

            char[] finalArray = new char[totalLength];

            // Every entry except the final root will have exactly one child.
            for (int i = 1; i <= number-1; i++) {
                operation = reader.readLine().split(" ");
                lastKey = operation[0];
                key2 = operation[1];

                strings.get(lastKey).children.add(strings.get(key2));
                strings.remove(key2);
            }
            
            int newIndex = recursiveAppend(strings.get(lastKey), finalArray, 0);
            
            String result = new String(finalArray);

            System.out.println(result);
    }

    static int recursiveAppend(CustomString string, char[] arr, int startIndex) {
        System.arraycopy(string.content, 0, arr, startIndex, string.content.length);
        int index = startIndex + string.content.length;
        while (string.children.peek() != null) {
            index = recursiveAppend(string.children.poll(), arr, index);
        }
        return index;
    }

    public static class CustomString {
        char[] content;
        Queue<CustomString> children;

        public CustomString (String str) {
            this.content = str.toCharArray();
            this.children = new LinkedList<CustomString>();
        }
    }

}