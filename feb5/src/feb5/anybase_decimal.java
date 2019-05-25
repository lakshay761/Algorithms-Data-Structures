package feb5;

import java.util.Scanner;

public class anybase_decimal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter number");
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();
		System.out.println("enter base");
		int base = scn.nextInt();
		int decimal = 0;
		int i = 1;
		while (number != 0) {
			int temp = number % 10;
			decimal += temp * i;
			i *= base;
			number /= 10;
		}
		System.out.println("converted decimal number is " + decimal);
	}
}
