import java.util.*;
import java.io.*;

public class AnotherCandies {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        
        while(testCases > 0) {
            testCases--;
            reader.readLine();

            long remainder = 0, candy = 0;
            long children = Long.parseLong(reader.readLine());
            long count = children;

            while(count > 0) {
                count--;
                candy = Long.parseLong(reader.readLine());

                if (candy > Long.MAX_VALUE - remainder) {
                    remainder += candy%children;
                } else {
                    remainder = (candy + remainder)%children;
                }
            }

            if (remainder == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}