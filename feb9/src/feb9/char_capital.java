package feb9;
import java.util.Scanner;

public class char_capital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a character");
		char ch = scn.next().charAt(0);
		int num = ch;
		if(ch >= 'A' && ch <='Z') {
			System.out.println("Upper");
			num = ch + 'a' - 'A';  
		}
		else if(ch >= 'a' && ch<='z') {
			System.out.println("Lower");
			num = ch - 'a' + 'A';
		}
		System.out.println((char)num); 			//type cast into char
	}

}
