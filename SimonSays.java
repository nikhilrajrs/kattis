import java.util.*;
import java.io.*;

public class SimonSays {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(reader.readLine());
        String pattern = "simon says ";

        while (number > 0) {
            number--;
            String input = reader.readLine();
            if (input.length() > 12 && pattern.equals(input.substring(0, 11))) {
                writer.write(input.substring(11));
                writer.newLine();
            } else {
                writer.newLine();
            }
        }
        writer.flush();
    }
}