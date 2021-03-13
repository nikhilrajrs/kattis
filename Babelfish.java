import java.util.*;
import java.io.*;

public class Babelfish {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> dictionary = new HashMap<>();
        String eh = "eh";

        while(true) {
            String input = reader.readLine();
            if (input.length() == 0) {
                break;
            } else {
                String[] words = input.split(" ");
                dictionary.put(words[1], words[0]);
            }
        }

        while(true) {
            String word = reader.readLine();
            if (word == null || word.isEmpty()) {
                break;
            } else {
                String meaning = dictionary.get(word);
                if (meaning == null) {
                    writer.write(eh);
                } else {
                    writer.write(dictionary.get(word));
                }
                writer.newLine();
            }
        }

        writer.flush();
    }
}