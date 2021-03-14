import java.util.*;
import java.io.*;

public class PlantingTrees {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int totalDays = 0, dayCount = 1;

        int[] seedlings = new int[number];
        String[] input = reader.readLine().split(" ");

        for (int count = 0; count < number; count++) {
            seedlings[count] = Integer.parseInt(input[count]);
        }

        Arrays.sort(seedlings);

        for (int count = number-1; count >= 0; count--, dayCount++) {
            if (seedlings[count] + dayCount > totalDays) {
                totalDays = seedlings[count] + dayCount;
            }

        }

        System.out.println(totalDays + 1);
    }
}