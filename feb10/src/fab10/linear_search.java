package fab10;

import java.util.Scanner;

public class linear_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30,40};
		System.out.println("Enter element to find");
		Scanner scn = new Scanner(System.in);
		int element = scn.nextInt();
		int pos = -1;
		for(int i=0;i<4;i++) {
			if(arr[i] == element) {
				pos =i;
				break;
			}
		}
		if(pos == -1) {
			System.out.println("Element not found");
		}
		else {
			
		
		System.out.println("The element found at " + (pos+1));
		}
		}

}
