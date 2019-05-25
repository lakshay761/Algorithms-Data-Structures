package feb9;

import java.util.Scanner;

public class bit_manipulate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a Number");
		byte num = scn.nextByte();
		System.out.println("enter the bit");
		byte k = scn.nextByte();
		byte bm = (byte)(1<<k);
		byte flag = (byte)(num & bm);
		byte newNum =0;
		if(flag ==0) {
			newNum = (byte)(num | bm);
			System.out.println(newNum);
		}
		else if(flag == bm) {
			System.out.println("The bit was on");
		}
	}

}
