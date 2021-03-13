import java.util.*;

public class Trik {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();

        BitSet cups = new BitSet(3);
        cups.set(0);

        for (char move : input) {
            switch(move) {
                case 'A':   if (cups.get(2)) {
                                continue;    
                            } else {
                                cups.flip(0);
                                cups.flip(1);
                            }
                    break;
                case 'B':   if (cups.get(0)) {
                                continue;    
                            } else {
                                cups.flip(1);
                                cups.flip(2);
                            }
                    break;
                case 'C':   if (cups.get(1)) {
                                continue;    
                            } else {
                                cups.flip(0);
                                cups.flip(2);
                            }
                    break;
            }
        }


        if (cups.get(0)) {
            System.out.println(1);
        } else if (cups.get(1)) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}