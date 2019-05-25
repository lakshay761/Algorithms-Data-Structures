package recursion2_feb24;

public class maxArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 9, 3, 7, 1 };
		System.out.println(max(a, 0));
	}

	private static int max(int[] arr, int sp) {
		if (sp == arr.length-1) {
			return arr[sp];
		}
		int m = max(arr, sp + 1);
		if (arr[sp] > m) {
			m = arr[sp];
		}
		return m;
	}
}
