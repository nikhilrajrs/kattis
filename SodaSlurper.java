import java.util.*;

public class SodaSlurper {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int empty = scanner.nextInt() + scanner.nextInt();
        int bottlesRequired = scanner.nextInt();

        int sodasDrunk = 0;

        while(empty >= bottlesRequired) {
            int newSodas = empty/bottlesRequired;
            sodasDrunk += newSodas;

            empty = empty%bottlesRequired + newSodas;
        }

        System.out.println(sodasDrunk);
    }
}