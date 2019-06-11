package ip1_n;

import java.util.*;

public class largestRectangleMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
		int[] height = new int[arr[0].length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i == 0) {
					height[j] = arr[i][j] == 1 ? 1 : 0;
				} else {
					height[j] = arr[i - 1][j] == 0 ? 0 : height[j] + 1;
				}
			}
			int a = maxRectArea(height);
			if(a >max) {
				max = a; 
			}
		}
		System.out.println(max);
	}

	public static int maxRectArea(int[] arr) {
		// write your code here
		Stack<Integer> st = new Stack<>();
		int[] rba = new int[arr.length];
		st.push(arr.length - 1);
		rba[0] = arr.length;
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			rba[i] = st.size() > 0 ? st.peek() : arr.length;
			st.push(i);
		}
		Stack<Integer> sn = new Stack<>();
		int[] lba = new int[arr.length];
		sn.push(0);
		lba[0] = -1;
		for (int i = 0; i < arr.length; i++) {
			while (sn.size() > 0 && arr[sn.peek()] >= arr[i]) {
				sn.pop();
			}
			lba[i] = sn.size() > 0 ? sn.peek() : arr.length;
			sn.push(i);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int carea = arr[i] * (rba[i] - lba[i] - 1);
			if (carea > max) {
				max = carea;
			}
		}
		return max;
	}
}
