package fab10;

public class rotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 5, 7, 9, 3, 6, 1 };
		int r = 3;

		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, r - 1);
		reverse(arr, r, arr.length - 1);

//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(" " + arr[i]);
//		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	private static void reverse(int[] arr, int low, int high) {
		for (int i = low, j = high; i < (high - low) / 2; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
