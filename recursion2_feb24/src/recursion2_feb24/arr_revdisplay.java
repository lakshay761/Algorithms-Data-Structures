package recursion2_feb24;

public class arr_revdisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,9,3,7,1};
		display(a,0);
	}
	private static void display(int[] arr , int sp) {
		if(sp == arr.length) {
			return;
		}
		display(arr , sp+1);
		System.out.println(arr[sp]);
	}
}
