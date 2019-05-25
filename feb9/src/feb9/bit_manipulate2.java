package feb9;

import java.util.Scanner;

public class bit_manipulate2 {

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
			System.out.println("The bit was off");
			
		}
		else if(flag == bm) {
			newNum = (byte)(num & ~bm); 	//negative bit mask is ~bm
			System.out.println(newNum);
		}
	}

}
