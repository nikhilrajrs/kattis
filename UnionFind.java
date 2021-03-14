import java.util.*;
import java.io.*;

public class UnionFind {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String blank = " ", equals = "=", yes = "yes", no = "no";
        int setCounter = 1;
        Integer first, second;
        
        String[] input = reader.readLine().split(blank);
        int n = Integer.parseInt(input[0]), q = Integer.parseInt(input[1]);

        List<Set<Integer>> master = new ArrayList<>(n > 1000 ? n/10 : 100);

        while (q > 0) {
            input = reader.readLine().split(blank);
            first = Integer.parseInt(input[1]);
            second = Integer.parseInt(input[2]);

            Set<Integer> firstSet = null, secondSet = null;
            boolean foundFirst = false, foundSecond = false, sameSet = false;
            for (Set<Integer> s : master) {
                if (!foundFirst && s.contains(first)) {
                    firstSet = s;
                    foundFirst = true;
                    //edge case; second element in same set
                    if (s.contains(second)) {
                        secondSet = s;
                        foundSecond = true;
                        sameSet = true;
                    }
                }
                if (!foundSecond && s.contains(second)) {
                    secondSet = s;
                    foundSecond = true;
                    //edge case; second element in same set
                    if (s.contains(first)) {
                        firstSet = s;
                        foundFirst = true;
                        sameSet = true;
                    }
                }
                if (foundFirst && foundSecond) {
                    break;
                }
            }

            if (input[0].equals(equals)) {
                if (!sameSet) {
                    if (firstSet == null && secondSet == null) {
                        // Add both to a single set and put in master
                        firstSet = new TreeSet<>();
                        firstSet.add(first);
                        firstSet.add(second);
                        master.add(firstSet);
                    } else if (secondSet == null) {
                        //first set exists
                        firstSet.add(second);
                    } else if (firstSet == null) {
                        //second set exists
                        secondSet.add(first);
                    } else {
                        // both sets exist
                        firstSet.addAll(secondSet);
                        master.remove(secondSet);
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