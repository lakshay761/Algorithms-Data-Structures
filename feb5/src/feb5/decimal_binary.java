package feb5;

import java.util.Scanner;

public class decimal_binary {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter decimal number");
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();
		int binary = 0;
		int i = 1;
		while (number != 0) {
			int temp = number % 2;
			binary += temp * i;
			i *= 10;
			number /= 2;
		}
		System.out.println("binary number is " + binary);
	}

}
