import java.util.*;

public class Tarifa {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int remaining = 0;

        while (n > 0) {
            n--;
            remaining += (x - scanner.nextInt());
        }

        System.out.println(remaining + x);
    }

}