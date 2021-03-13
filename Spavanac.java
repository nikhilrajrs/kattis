import java.util.*;

public class Spavanac {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        
        if (m >= 45) {
            m -= 45;
        } else {
            int r = 45 - m;
            m = 60 - r;
            if (h == 0) {
                h = 23;
            } else {
                h--;
            }
        }

        System.out.println(h + " " + m);
    }

}