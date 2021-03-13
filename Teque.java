import java.util.*;
import java.io.*;

public class Teque {

    public static void main(String args[]) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        TequeClass teque = new TequeClass();

        while(number > 0) {
            number--;
            String[] input = reader.readLine().split(" ");
            int newElement = Integer.parseInt(input[1]);

            switch(input[0]) {
                case "push_back":   teque.addLast(newElement);
                                    break;
                case "push_front":  teque.addFirst(newElement);
                                    break;
                case "push_middle": teque.addMiddle(newElement);
                                    break;
                default:            System.out.println(teque.get(newElement));
                                    break;  
            }
        }
    }

    private static class TequeClass {
        Node first;
        Node last;
        Node middle;

        int size;
        
        public TequeClass() {
            size = 0;
            middleIndex = 0;
        }

        public void addLast(int newElement) {
            if (this.first == null) {
                this.first = new Node(newElement);
            } else if (this.last == null) {
                //Edge case - addLast called right after a single addFirst
                this.last = new Node(newElement);
                this.last.previous = this.first;
                this.first.next = this.last;
            } else {
                Node temp = this.last;
                Node newLast = new Node(newElement);
                newLast.previous = temp;
                this.last = newLast;
                temp.next = this.last;
            }
            size++;
            if (this.middle != null && middleIndex < (size + 1) / 2) {
                this.middle = this.middle.next;
                middleIndex++;
            }
        }

        public void addMiddle(int newElement) {
            if (this.first == null) {
                this.first = new Node(newElement);
            } else if (this.last == null) {
                //Edge case - addMiddle called right after a single addFirst
                this.last = new Node(newElement);
                this.last.previous = this.first;
                this.first.next = this.last;
            } else if (this.middle != null) {
                Node newMiddle = new Node(newElement);
                if (middleIndex < (size + 1) / 2)) {
                    //insert to next index
                    Node temp = this.middle;
                    this.middle = newMiddle;
                    this.middle.next = temp.next;
                    this.middle.previous = temp;
                    temp.next.previous = this.middle;
                    temp.next = this.middle;
                    middleIndex++;
                } else {
                    Node temp = this.middle;
                    this.middle = newMiddle;
                }
            } else {
                int insertionPoint = (size + 1)/2;
                Node temp = this.first;
                while (insertionPoint > 0) {
                    insertionPoint--;
                    temp = temp.next;
                }
                Node newMiddle = new Node(newElement);
                if (temp == null) {
                    //Edge case - middle is last
                    temp = this.last;
                    temp.next = newMiddle;
                    newMiddle.previous = temp;
                    this.last = newMiddle;
                } else {
                    newMiddle.previous = temp.previous;
                    temp.previous.next = newMiddle;
                    newMiddle.next = temp;
                    temp.previous = newMiddle;
                }
                this.middle = newMiddle;
                middleIndex = insertionPoint;
            }
            size++;
        }

        public void addFirst(int newElement) {
            if (this.first == null) {
                this.first = new Node(newElement);
            } else {
                Node temp = this.first;
                Node newFirst = new Node(newElement);
                newFirst.next = temp;
                this.first = newFirst;
                temp.previous = this.first;
                if (this.last == null) {
                    this.last = temp;
                }
            }
            size++;
            if (this.middle != null && middleIndex < (size + 1) / 2) {
                this.middle = this.middle.next;
                middleIndex++;
            }     
        }

        public int get(int index) {
            Node start = null;
            int count = 0;
            if (this.size > 10 && index > this.size/2) {
                start = this.last;
                count = this.size - index - 1;
                while (count > 0) {
                    count--;
                    start = start.previous;
                }
            } else {
                start = this.first;
                count = index;
                while (count > 0) {
                    count--;
                    start = start.next;
                }
            }
            return start.content;
        }

    }

    private static class Node {
        int content;
        Node next;
        Node previous;

        public Node(int input) {
            this.content = input;
        }
    }
}