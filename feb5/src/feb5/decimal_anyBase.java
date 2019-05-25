package feb5;

import java.util.Scanner;

public class decimal_anyBase {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter decimal number");
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();
		System.out.println("enter base");
		int base = scn.nextInt();
		int baseNum = 0;
		int i = 1;
		while (number != 0) {
			int temp = number % base;
			baseNum += temp * i;
			i *= 10;
			number /= base;
		}
		System.out.println("converted number is " + baseNum);
	}
}
