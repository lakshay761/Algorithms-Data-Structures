package recursion2_feb24;

public class arraydisplay_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,9,3,7,1};
		display(a,0);
	}
	private static void display(int[] arr , int sp) {
		if(sp == arr.length) {
			return;
		}
		System.out.println(arr[sp]);
		display(arr , sp+1);
	}
}
