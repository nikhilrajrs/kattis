import java.util.*;
import java.io.*;

public class CD {

    public static void main(String args[]) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int jack = Integer.parseInt(firstLine[0]);
        int jill = Integer.parseInt(firstLine[1]);
        int bothOwn = 0;
        Set<String> jackSet;

        while (true) {
            bothOwn = 0;
            jackSet = new HashSet<>();
            
            for (int k = 0; k < jack; k++) {
                jackSet.add(reader.readLine());
            }
            
            for (int k = 0; k < jill; k++) {
                if (jackSet.contains(reader.readLine())) {
                    bothOwn++;
                }
            }

            System.out.println(bothOwn);

            firstLine = reader.readLine().split(" ");
            jack = Integer.parseInt(firstLine[0]);
            jill = Integer.parseInt(firstLine[1]);

            if (jack == 0 && jill == 0) {
                break;
            }
        }
    }

}