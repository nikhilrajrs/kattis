import java.util.*;
import java.io.*;

public class ABC {

    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[3];
        numbers[0] = scanner.nextInt();
        numbers[1] = scanner.nextInt();
        numbers[2] = scanner.nextInt();
        Arrays.sort(numbers);
        scanner.nextLine();

        char[] order = scanner.nextLine().toCharArray();

        String result = "";
        for (char c : order) {
            switch (c) {
                case 'A': result += numbers[0] + " ";
                    break;
                case 'B': result += numbers[1] + " ";
                    break;
                case 'C': result += numbers[2] + " ";
                    break;
            }
        }

        System.out.println(result.substring(0, result.length() - 1));
    }
}