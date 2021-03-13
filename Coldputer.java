import java.util.*;

public class Coldputer {
    
    public static void main(String argsp[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfReadings = scanner.nextInt();
        int belowZeroReadings = 0;

        while(noOfReadings > 0) {
            noOfReadings--;
            if (scanner.nextInt() < 0) {
                belowZeroReadings++;
            }
        }
        System.out.println(belowZeroReadings);
    }
}