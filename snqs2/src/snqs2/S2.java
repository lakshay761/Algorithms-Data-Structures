package snqs2;

import java.lang.reflect.Array;
import java.util.*;

public class S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = { 4, 9, 5, 2, 7, 10, 6, 12, 8, 15 };
//		int[] r = slidingWindow(a, 5);
//		for (int i = 0; i < r.length; i++) {
//			System.out.print(a[r[i]] + " ");
//		}

//		String s1 = "((a+b) + ((c+d)))";
//		String s2 = "(a)";
//		System.out.println(balanceBrackets(s1));
//		
//		boolean[][] a = {{false, false,true,false,true,true},
//						{true,false,true,true,true,true},
//						{true,false,false,true,true,true},
//						{true,true,true,false,true,false},
//						{false,false,false,false,false,false},
//						{true,false,true,true,true,false}};
//		celebrity(a);
		int[] start = { 22, 17, 19, 2, 6, 12, 3 };
		int[] end = { 26, 20, 23, 4, 9, 15, 7 };
		OverlappingIntervals(start, end);
		int[] x = {1,2,3,2,6,1,5,4,2,7};
		stockSpan(x);
		
	}

	public static int[] slidingWindow(int[] arr, int k) {

		// finding nge right
		int[] nge = new int[arr.length];
		Stack<Integer> st = new Stack<>();

		nge[arr.length - 1] = arr.length;
		st.push(arr.length - 1);

		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[i] > arr[st.peek()]) {
				st.pop();
			}

			nge[i] = st.size() > 0 ? st.peek() : arr.length;
			st.push(i);
		}

		// 2
		int[] res = new int[arr.length - k + 1];

		for (int i = 0, j = 0; i < arr.length - k + 1; i++) {
			if (j < i) {
				j = i;
			}
			while (nge[j] < i + k) {
				j = nge[j];
//				System.out.println("2");
			}
			res[i] = j;
		}
		return res;

	}

	public static boolean balanceBrackets(String str) {

		Stack<Character> st = new Stack<>();
//		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				if (st.peek() == '(') {
					return true;
				} else {
					while (st.peek() != '(') {
						st.pop();
					}
					st.pop();
				}

			} else {
				st.push(str.charAt(i));
			}
		}
		return false;
	}

	public static void celebrity(boolean[][] know) {
		int[] arr = new int[know.length];
		for (int i = 0; i < know.length; i++) {
			arr[i] = i;
		}
		int left = 0;
		int right = arr.length - 1;
		while (left != right) {
			if (know[left][right] == true) {
				left++;
			} else {
				right--;
			}
		}
		boolean flag = true;
		for (int i = 0; i < know.length; i++) {
			if (i != left) {
				if (know[left][i] == true) {
					flag = false;
				}
			}
		}
		if (flag == true) {
			for (int i = 0; i < know.length; i++) {
				if (i != left) {
					if (know[i][left] == false) {
						flag = false;
					}
				}
			}
		}
		if (flag == true) {
			System.out.println(left + " is a celebrity");
		} else {
			System.out.println("No celebrity");
		}
	}

	public static class Interval implements Comparable<Interval> {
		public int start;
		public int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Interval o) {
			return this.start - o.start;
		}

	}

	public static void OverlappingIntervals(int[] start, int[] end) {
		Interval[] intvs = new Interval[start.length];
		for (int i = 0; i < start.length; i++) {
			intvs[i] = new Interval(start[i], end[i]);
		}
		Arrays.sort(intvs);

		Stack<Interval> st = new Stack<>();
		st.push(intvs[0]);
		for (int i = 0; i < start.length; i++) {
			if (intvs[i].start < st.peek().end) {
				st.peek().end = Math.max(intvs[i].end, st.peek().end);
			} else {
				st.push(intvs[i]);
			}
		}

		while (st.size() > 0) {
			System.out.print(st.peek().start + " - " + st.peek().end);
			System.out.println("");
			st.pop();
		}
	}

	public static void stockSpan(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[arr.length];
		st.push(0);
		res[0] = -1;
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] > arr[st.peek()]) {
				st.pop();
			}
			res[i] = st.size() > 0 ? st.peek() : -1;
			st.push(i);
		}
		int[] fres = new int[arr.length];
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			fres[i] = i - res[i];
			System.out.print(fres[i] + " ");
		}
	}

//	public static boolean bBrackets1()
//	{
//		
//	}
}
