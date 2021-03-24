import java.util.*;

public class RotateBinary {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		System.out.println(rotateBinary(x));
	}

    public static int rotateBinary(int number){
		int reversed = 0;
		while (number>0) {
			reversed <<= 1; 		
			reversed |= (number & 1); 			
			number >>= 1;
		}
		return reversed;
	}

}