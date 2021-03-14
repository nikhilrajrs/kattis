import java.util.*;
import java.io.*;

public class SortOfSorting {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(reader.readLine());

        Comparator<String> firstTwoChar = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String first = o1.substring(0, 2);
                String second = o2.substring(0, 2);
                return first.compareTo(second);
            }
        };

        while (number > 0) {
            String[] names = new String[number];

            for (int count = 0; count < number; count ++) {
                names[count] = reader.readLine();
            }

            Arrays.sort(names, firstTwoChar);

            for (int count = 0; count < number; count ++) {
                writer.write(names[count]);
                writer.newLine();
            }
            writer.newLine();

            number = Integer.parseInt(reader.readLine());
        }

        writer.flush();
    }
}
