package first;

import java.util.Scanner;

public class counting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn =new Scanner(System.in);
		System.out.println("please enter a number");
		
		int n = scn.nextInt();
		
		int counter =1;
		while(counter<=n) {
			System.out.println(counter);
			counter++;
		}
	}

}
