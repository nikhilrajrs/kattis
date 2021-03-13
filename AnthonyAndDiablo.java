import java.util.*;

public class AnthonyAndDiablo {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double n = scanner.nextDouble();

        double r = n/(2 * 3.14);
        double area = 3.14 * r * r;

        if (area > a) {
            System.out.println("Diablo is happy!");
        } else {
            System.out.println("Need more materials!");
        }
    }
}