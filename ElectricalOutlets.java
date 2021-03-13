import java.util.*;

public class ElectricalOutlets {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while(testCases > 0) {
            testCases--;
            int powerStrips = scanner.nextInt();
            int noOfAppliances = 0;

            while(powerStrips > 0) {
                powerStrips--;
                noOfAppliances += scanner.nextInt() - 1;
            }

            System.out.println(noOfAppliances + 1);
        }
    }
}