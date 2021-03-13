import java.util.*;
import java.io.*;

public class BusNumbers {

    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        int n = scanner.nextInt();
        scanner.nextLine();

        int[] buses = new int[n];

        for (int i = 0; i < n; i++) {
            buses[i] = scanner.nextInt();
        }

        Arrays.sort(buses);

        int first = buses[0];
        int last = buses[0];
        
        for (int i = 1; i < n; i++) {
            if (buses[i] == last + 1) {
                last = buses[i];
            } else {
                if (first == last) {
                    builder.append(first);
                    builder.append(" ");
                } else if (last == first + 1) {
                    builder.append(first);
                    builder.append(" ");
                    builder.append(last);
                    builder.append(" ");
                } else {
                    builder.append(first);
                    builder.append("-");
                    builder.append(last);
                    builder.append(" ");
                }
                first = buses[i];
                last = buses[i];
            }
        }

        if (first == last) {
            builder.append(first);
        } else if (last == first + 1) {
            builder.append(first);
            builder.append(" ");
            builder.append(last);
        } else {
            builder.append(first);
            builder.append("-");
            builder.append(last);
        }

        System.out.println(builder.toString());
    }
}