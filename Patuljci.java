import java.util.*;

public class Patuljci {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int[] dwarves = new int[9];
        int total = 0, firstImpIndex = -1, secondImpIndex = -1;
                
        for (int i = 0; i < 9; i++) {
            dwarves[i] = scanner.nextInt();
            total += dwarves[i];
        }

        int overFlow = total - 100;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarves[i] + dwarves[j] == overFlow) {
                    firstImpIndex = i;
                    secondImpIndex = j;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != secondImpIndex && i != firstImpIndex) {
                System.out.println(dwarves[i]);
            }
        }
    }

}