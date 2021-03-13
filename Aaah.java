import java.util.*;

public class Aaah{
    public static void main(String args[]) {
        int jon = System.console().readLine().length();
        int doctor = System.console().readLine().length();

        if (jon < doctor) {
            System.out.println("no");
        } else {
            System.out.println("go");
        }
    }
}