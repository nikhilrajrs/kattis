import java.util.*;

public class ADifferentProblem {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.isEmpty()) {
                break;
            } else {
                String[] inputs = nextLine.split(" ");
                long r = Long.parseLong(inputs[0]);
                long s = Long.parseLong(inputs[1]);
                if (r > s) {
                    System.out.println(r - s);
                } else {
                    System.out.println(s - r);
                }
            }
        }
    }

}