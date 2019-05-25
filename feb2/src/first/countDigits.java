package first;

import java.util.Scanner;

public class countDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter number");
		Scanner scn = new Scanner(System.in);
		long number = scn.nextLong();
		int i=0;
		for( i=0; number !=0; i++) {
			number = number/10;
		}
		System.out.println(i);
	}

}
