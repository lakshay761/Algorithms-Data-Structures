package feb9;

import java.util.Scanner;

public class count1_RSBM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a Number");
		int num = scn.nextInt();
		System.out.println(Integer.toBinaryString(num));
		int counter = 0;
		while (num != 0) {
			int rsbm = (num & (-1 * num));
			num = num -rsbm;
			counter ++;
		}
		System.out.println("the number of ones are " + counter);
	}

}
