package feb5;

import java.util.Scanner;

public class binary_decimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter binary number");
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();
		int decimal = 0;
		int i = 1;
		while (number != 0) {
			int temp = number % 10;
			decimal += temp * i;
			i *= 2;
			number /= 10;
		}
		System.out.println("decimal number is " + decimal);
	}
}
