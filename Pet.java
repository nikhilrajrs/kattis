import java.util.*;

public class Pet {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int winner = 0, points = 0;

        for (int count = 1; count <= 5; count++) {
            String[] inputs = in.nextLine().split(" ");
            int currentPoints = Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]) +
                                    Integer.parseInt(inputs[2]) + Integer.parseInt(inputs[3]);
            if (currentPoints > points) {
                winner = count;
                points = currentPoints;
            }
        }
        System.out.println(winner + " " + points);
    }

}