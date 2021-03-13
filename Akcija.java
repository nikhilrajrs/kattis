import java.util.*;
import java.io.*;

public class Akcija {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int[] bookPrices = new int[number];
        int minimalSum = 0;

        for (int count = 0; count < number; count++) {
            bookPrices[count] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(bookPrices);

        while(number >= 3) {
            minimalSum += bookPrices[number-1] + bookPrices [number-2];
            number -= 3;
        }

        if (number > 0) {
            minimalSum += bookPrices[0];
            if (number == 2) {
                minimalSum += bookPrices[1];
            }
        }

        System.out.println(minimalSum);

    }

}
