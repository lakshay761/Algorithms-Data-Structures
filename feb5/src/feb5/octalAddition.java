package feb5;

import java.util.Scanner;

public class octalAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter first number");
		Scanner scn = new Scanner(System.in);
		int num1 = scn.nextInt();
		System.out.println("enter second number");
		int num2 = scn.nextInt();

		int carry = 0;
		int num = 0;
		int i =1;
		while(num1 !=0 || num2!= 0){
			
			int dig1 = num1%10;
			int dig2 = num2%10;
			int dig3 = (dig1+dig2 + carry)%8;
			
			num += dig3*i;
			carry = (dig1+dig2 + carry)/8;
			num1 /=10;
			num2 /=10;
			i *=10;
		}
		num+= i*carry;
		System.out.println(num);
	}

}
