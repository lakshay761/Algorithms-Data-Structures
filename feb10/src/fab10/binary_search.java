package fab10;

import java.util.Scanner;

public class binary_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		System.out.println("Enter element to find");
		Scanner scn = new Scanner(System.in);
		int element = scn.nextInt();
		int high = 5;
		int low = 0;
		int mid = 0;
		while (high >= low) {
			mid = (low + high) / 2;
			if (arr[mid] == element) {
				int pos = mid;
				System.out.println("Element found at position " + pos);
				return;
			} else if (element < arr[mid]) {
				high = mid - 1;
			} else if (element > arr[mid]) {
				low = mid + 1;
			}

		}
		System.out.println("Element not found");
	}

}
