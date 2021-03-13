import java.util.*;
import java.io.*;

public class BackSpace {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder(10000);
        int index = 0;
        char[] input = reader.readLine().toCharArray();

        for (char c : input) {
            if (c != 60) {
                builder.append(c);
                index++;
            } else {
                index--;
                builder.deleteCharAt(index);
            } 
        }
        
        System.out.println(builder.toString());
    }

}