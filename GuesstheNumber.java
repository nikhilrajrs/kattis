import java.util.*;
import java.io.*;

public class GuesstheNumber {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int start = 1;
        int end = 1000;
        int middle = end/2;
        boolean flag = true;

        while (flag) {
            System.out.println(middle);

            String response = scanner.nextLine();

            switch(response) {
                case "lower":   if (start == middle - 1){
                                    System.out.println(start);
                                    flag = false;                        
                                } else {
                                    end = middle - 1;
                                }
                            break;
                case "higher":  if (end == middle + 1){
                                    System.out.println(end);
                                    flag = false;                        
                                } else {
                                    start = middle + 1;
                                }
                            break;
                default:   flag = false;
            }
            middle = start + ((end - start)/2);
        }
    }

}