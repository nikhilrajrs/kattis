import java.util.*;

public class Alloys {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextDouble();

        if (money == 0.0) {
            System.out.println(money);
        } else {
            if (money > 1) {
                money = 1;
            }
            System.out.println(money/2 * money/2);
        }
    }
}