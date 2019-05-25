package snqs1;

import java.util.*;

public class s1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String in = "iddiidid";
//		ddii(in);
		int[] arr = { 6,2,5,4,5,1,6};
		nge(arr);
		System.out.println();
	//	System.out.println(nse(arr));
	//System.out.println(pse(arr));
		maxArea(arr);
	}

	public static void ddii(String in) {
		Stack<Integer> st = new Stack<>();
		int num = 1;
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == 'd') {
				st.push(num);
				num++;
			} else if (in.charAt(i) == 'i') {
				st.push(num);
				num++;
				while (st.size() > 0) {
					System.out.print(st.peek());
					st.pop();
				}
			}
		}
		st.push(num);
		while (st.size() > 0) {
			System.out.print(st.peek());
			st.pop();
		}
	}

	public static void nge(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int ans;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (st.empty()) {
				System.out.print(-1 + " ");
				st.push(arr[i]);
			} else {
				while (st.size() > 0 && arr[i] > st.peek()) {
					st.pop();
				}
				ans = st.size() > 0 ? st.peek() : -1;
				System.out.print(ans + " ");
				st.push(arr[i]);
			}
		}
	}

	public static void lnge(int[] arr) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] > arr[st.peek()]) {
				res[st.peek()] = arr[i];
				st.pop();
			}

		}

	}

	public static int[] nse(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[arr.length];
		st.push(arr.length - 1);
		res[arr.length - 1] = -1;
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[i] < arr[st.peek()]) {
				st.pop();
			}
			res[i] = st.size() > 0 ? st.peek() : -1;
			st.push(i);
		}
		return res;
	}

	public static int[] pse(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[arr.length];
		st.push(0);
		res[0] = -1;
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] < arr[st.peek()]) {
				st.pop();
			}
			res[i] = st.size() > 0 ? st.peek() : -1;
			st.push(i);
		}
		return res;
	}

	public static void maxArea(int[] arr) {	
		Stack<Integer> st1 = new Stack<>();
		int[] rb = new int[arr.length];
		st1.push(arr.length - 1);
		rb[arr.length - 1] = arr.length;
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st1.size() > 0 && arr[i] < arr[st1.peek()]) {
				st1.pop();
			}
			rb[i] = st1.size() > 0 ? st1.peek() : arr.length;
			st1.push(i);
		}
		//
		Stack<Integer> st2 = new Stack<>();
		int[] lb = new int[arr.length];
		st2.push(0);
		lb[0] = -1;
		for (int i = 1; i < arr.length; i++) {
			while (st2.size() > 0 && arr[i] < arr[st2.peek()]) {
				st2.pop();
			}
			lb[i] = st2.size() > 0 ? st2.peek() : -1;
			st2.push(i);
		}
		for(int k=0;k<arr.length;k++) {
		System.out.print(rb[k]);
		}
		System.out.println();
		for(int k=0;k<arr.length;k++) {
		System.out.print(lb[k]);
		}
		
		int max  = Integer.MIN_VALUE;
		int[] area = new int[arr.length];
		for(int i = 0;i<arr.length;i++) {
			area[i] = (rb[i] - lb[i] - 1) * arr[i];
			if(area[i] > max) {
				max = area[i];
			}
		}
		System.out.println();
		System.out.println(max);
	}
}
