package feb5;

import java.util.Scanner;

public class octal_binary {

	public static void main(String[] args) {
		System.out.println("enter octal number");
		Scanner scn = new Scanner(System.in);
		int octal = scn.nextInt();
		long bin = 0;
		int b = 0;
		int i=1;
		while(octal !=0) {
			int rem = octal%10;
			octal = octal/10;
			switch(rem) {
			case 0: b = 0;
					break;
			case 1: b = 1;
			break;
			case 2: b = 10;
			break;
			case 3: b = 11;
			break;
			case 4: b = 100;
			break;
			case 5: b = 101;
			break;
			case 6: b = 110;
			break;
			case 7: b = 111;
			break;
			}
			bin +=b*i;
			i*=1000;
		}
		System.out.println(bin);
	}

}
