import java.util.*;
import java.io.*;

public class OneChickenPerPerson {

    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int people = scanner.nextInt();
        int chicken = scanner.nextInt();

        boolean single = Math.abs(chicken - people) == 1;
        
        if (people < chicken) {
            if (single) {
                System.out.println("Dr. Chaz will have " + (chicken - people) + " piece of chicken left over!");
            } else {
                System.out.println("Dr. Chaz will have " + (chicken - people) + " pieces of chicken left over!");
            }
        } else {
            if (single) {
                System.out.println("Dr. Chaz needs " + (people - chicken) + " more piece of chicken!");
            } else {
                System.out.println("Dr. Chaz needs " + (people - chicken) + " more pieces of chicken!");
            }
        }
    }
}