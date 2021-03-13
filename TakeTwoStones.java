import java.util.*;

public class TakeTwoStones {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1 || input % 2 != 0) {
            System.out.println("Alice");
        } else {
            System.out.println("Bob");
        }
    }
}