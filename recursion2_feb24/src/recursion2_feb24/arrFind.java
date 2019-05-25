package recursion2_feb24;

public class arrFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 9, 3, 7, 1 };
		System.out.println(find(a, 0,7));
	}

	private static boolean find(int[] arr, int sp, int x) {
		if (sp == arr.length) {
			return false;
		}
		boolean m = find(arr, sp + 1,x);
		if (m == true) {
			return true;
		}
		else if(arr[sp] == x) {
			return true;
		}
		else {
			return false;
		}
	}
}