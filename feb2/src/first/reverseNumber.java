package first;

import java.util.Scanner;

public class reverseNumber {

	public static void main(String[] args) {
		System.out.println("enter number");
		Scanner scn = new Scanner(System.in);
		long number = scn.nextLong();
		long revNumber=0;
		while(number !=0) {
			revNumber = number%10;
			System.out.print(revNumber);
			number = number /10;
		}

	}

}
