import java.util.*;

public class SolvingForCarrots {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String[] inputs = in.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int p = Integer.parseInt(inputs[1]);

        for (int count = 0; count < n; count++) {
            in.nextLine();
        }

        System.out.println(p);
    }

}