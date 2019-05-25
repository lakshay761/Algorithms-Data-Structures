package first;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter number");
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();
		int counter = 2;
		int flag = 0;
		while(counter < number) {
			if(number%counter == 0) {
				flag = 1;
			}
			counter++;
		}
		if(flag == 1) {
			System.out.println("number is composite");		
		}
		else {
			System.out.println("number is prime");
		}
	}

}
