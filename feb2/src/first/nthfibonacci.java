package first;

import java.util.Scanner;

public class nthfibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter number");
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();
		int first = 0;
		int second = 1;
		int third;
		for(int i=2;i <= number;i++) {
			third = first+second;
			first = second;
			second = third; 
		}
		System.out.println(second);
	}
	

}
