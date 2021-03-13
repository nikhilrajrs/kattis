import java.util.*;

public class Modulo {
    
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int input;
        Set<Integer> modSet = new HashSet<>();

        while (scanner.hasNextInt()) {
            input = scanner.nextInt();
            modSet.add(input % 42);
        }

        System.out.println(modSet.size());
    }

}