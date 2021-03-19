import java.util.*;
import java.io.*;

public class UnionFind {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String blank = " ", equals = "=", yes = "yes", no = "no";
        int first, second;
        int firstIndex, secondIndex;
        int newIndex = 0;
        
        String[] input = reader.readLine().split(blank);
        int n = Integer.parseInt(input[0]), q = Integer.parseInt(input[1]);

        List<List<Integer>> master = new ArrayList<>(n > 1000 ? n : 500);
        //Map<String, Integer> indexMap = new HashMap<>(n > 1000 ? n : 500);
        int[] indexMap = new int[n];
        Arrays.fill(indexMap, -1);

        while (q > 0) {
            input = reader.readLine().split(blank);
            first = Integer.parseInt(input[1]);
            second = Integer.parseInt(input[2]);

            firstIndex = indexMap[first];
            secondIndex = indexMap[second];

            boolean sameSet = false;

            List<Integer> firstSet = firstIndex != -1 ? master.get(firstIndex) : null, 
                            secondSet = secondIndex != -1 ? master.get(secondIndex) : null;

            if (firstIndex != -1 && firstIndex == secondIndex) {
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
                        
                        indexMap[first] = newIndex;
                        indexMap[second] = newIndex;

                        newIndex++;
                    } else if (secondSet == null) {
                        //first set exists
                        firstSet.add(second);
                        indexMap[second] = firstIndex;
                    } else if (firstSet == null) {
                        //second set exists
                        secondSet.add(first);
                        indexMap[first] = secondIndex;
                    } else {
                        // both sets exist
                        firstSet.addAll(secondSet);
                        master.remove(secondSet);

                        for (int i : secondSet) {
                            indexMap[i] = firstIndex;
                        }
                    }
                }
            } else {
                if (sameSet || first == second) {
                    writer.write(yes);
                } else {
                    writer.write(no);
                }
                writer.newLine();
            }
            q--;
        }
        writer.flush();
    }
}