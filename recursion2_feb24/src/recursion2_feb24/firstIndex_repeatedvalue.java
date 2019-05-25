package recursion2_feb24;

public class firstIndex_repeatedvalue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 11, 3, 11, 11, 9, 7, 4, 11 };
		System.out.println(find(a,0,11));
	}
	private static int find(int[] arr, int sp, int x) {
		if (sp == arr.length) {
			return -1;
		}
		if(arr[sp] == x) {
			return sp;
		}
		int fiso = find(arr,sp+1,x);
		return fiso;
	}
}
