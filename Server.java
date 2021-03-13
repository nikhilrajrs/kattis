import java.util.*;
import java.io.*;

public class Server {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int count = 0, timeConsumed = 0;
        boolean full = false;

        while(n > 0) {
            n--;
            timeConsumed += scanner.nextInt();

            if (!full) {
                if (timeConsumed > t) {
                    full = true;
                } else {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}