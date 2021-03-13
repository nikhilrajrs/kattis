import java.util.*;

public class HashCollissionTester {
    public static void main(String args[]) {
        Map<String, String> map = new HashMap<>(1000000);

        for (int i = 0; i < 10000; i++) {
            System.out.println(Integer.toString(i).hashCode());
            if (map.get(Integer.toString(i)) != null) {
                System.out.println("HashCollission for " + i + " and " + map.get(Integer.toString(i)));
            } else {
                map.put(Integer.toString(i), Integer.toString(i));
            }
        }
    }
}