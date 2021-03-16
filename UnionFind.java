import java.util.*;
import java.io.*;

public class UnionFind {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String blank = " ", equals = "=", yes = "yes", no = "no";
        String first, second;
        Integer firstIndex, secondIndex;
        int newIndex = 0;
        
        String[] input = reader.readLine().split(blank);
        int n = Integer.parseInt(input[0]), q = Integer.parseInt(input[1]);

        List<List<String>> master = new ArrayList<>(n > 1000 ? n : 500);
        Map<String, Integer> indexMap = new HashMap<>(n > 1000 ? n : 500);

        while (q > 0) {
            input = reader.readLine().split(blank);
            first = input[1];
            second = input[2];

            firstIndex = indexMap.get(first);
            secondIndex = indexMap.get(second);

            boolean sameSet = false;

            List<String> firstSet = firstIndex != null ? master.get(firstIndex) : null, 
                            secondSet = secondIndex != null ? master.get(secondIndex) : null;

            if (firstIndex != null && firstIndex.equals(secondIndex)) {
                sameSet = true;
            }
            
            if (input[0].equals(equals)) {
                if (!sameSet) {
                    if (firstSet == null && secondSet == null) {
                        // Add both to a single set and put in master
                        firstSet = new ArrayList<>(n > 1000 ? n : 500);
                        firstSet.add(first);
                        firstSet.add(second);

                        master.add(newIndex, firstSet);
                        
                        indexMap.put(first, newIndex);
                        indexMap.put(second, newIndex);

                        newIndex++;
                    } else if (secondSet == null) {
                        //first set exists
                        firstSet.add(second);
                        indexMap.put(second, firstIndex);
                    } else if (firstSet == null) {
                        //second set exists
                        secondSet.add(first);
                        indexMap.put(first, secondIndex);
                    } else {
                        // both sets exist
                        firstSet.addAll(secondSet);
                        master.remove(secondSet);

                        for (String i : secondSet) {
                            indexMap.put(i, firstIndex);
                        }
                    }
                }
            } else {
                if (sameSet || first.equals(second)) {
                    writer.write(yes);
                } else {
                    writer.write(no);
                }
                writer.newLine();
                writer.flush();
            }
            q--;
        }
        writer.flush();
    }
}