package feb5;

import java.util.Scanner;

public class octalubtract {

	public static void main(String[] args) {
		System.out.println("enter first number");
		Scanner scn = new Scanner(System.in);
		int num1 = scn.nextInt();
		System.out.println("enter second number");
		int num2 = scn.nextInt();
		int borrow = 0;
		int num = 0;
		int i =1;
		while(num1 !=0 ){
			
			int dig1 = num1%10;
			int dig2 = num2%10;
			int add = dig1 + borrow < dig2?8:0; 
			
			int dig3 = (dig1 + add- dig2 + borrow);
			
			num += dig3*i;
			borrow = dig1 + borrow<dig2?-1:0;
			num1 /=10;
			num2 /=10;
			i *=10;
		}
		
		System.out.println(num);
	}
	}

