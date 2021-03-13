import java.util.*;

public class Bijele {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");

        int[] validCount = {1,1,2,2,2,8};
        int[] missingCount = new int[6];

        for (int i = 0; i < inputs.length; i++) {
            missingCount[i] = validCount[i] - Integer.parseInt(inputs[i]);
        }

        StringBuilder builder = new StringBuilder();
        for (int i : missingCount) {
            builder.append(i).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);

        System.out.println(builder.toString());
    }    
}