import java.util.*;
import java.text.*;
import java.math.*;

public class AboveAverage {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for(int i = 0; i < testCases; i++) {
            int people = sc.nextInt();
            int aboveAvg = 0;
            int[] arr = new int[people];
            double average = 0;

            for(int j = 0; j < people; j++) {
                arr[j] = sc.nextInt();
                average += arr[j];
            }

            average = average/people;

            for(int j = 0; j < people; j++) {
                if(arr[j] > average) {
                    aboveAvg++;
                }
            }
            System.out.printf("%.3f%s  \n",(double)aboveAvg/people * 100,"%");
        }
    }

}