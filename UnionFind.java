import java.util.*;
import java.io.*;

public class UnionFind {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String blank = " ", equals = "=";
        int setCounter = 1;
        Integer first, second;
        
        String[] input = reader.readLine().split(blank);
        int n = Integer.parseInt(input[0]), q = Integer.parseInt(input[1]);

        Map<Integer, Set> master = new HashMap<>();

        while (q > 0) {
            input = reader.readLine().split(blank);
            
            if (input[0].equals(equals)) {
                if (!input[1].equals(input[2])) {
                    first = setMap.get(input[1]);
                    second = setMap.get(input[2]);

                    if (first != null) {
                        
                    }
                }
            } else {

            }
        }
    }
}