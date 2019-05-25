package first;

import java.util.Scanner;

public class primeTilln {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter number");
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();
		int divisor ;
		int counter = 2;
		int flag;
		System.out.println("prime numbers are");
		while(counter <= number) {
			flag =0;
			divisor = 2;
			while(divisor < counter) {
				if(counter % divisor == 0) {
					flag = 1;
				}
				divisor++;
			}
			if(flag == 0) {
			System.out.println(divisor);
			}
		counter++;
		}
	}

}
