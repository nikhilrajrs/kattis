import java.util.*;
import java.lang.Math;

public class Ladder {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        double v = Math.toRadians(scanner.nextInt());

        System.out.println((int) Math.ceil(h / Math.sin(v)));
    }
}