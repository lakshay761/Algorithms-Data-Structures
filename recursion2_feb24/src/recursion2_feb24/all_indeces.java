package recursion2_feb24;

public class all_indeces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 11, 3, 11, 11, 9, 7, 4, 11 };
		int result[] = all(a, 0, 11, 0);
		for(int i=0;i< result.length;i++) {
			System.out.print(result[i] + " ");
		}
	}

	private static int[] all(int[] arr, int sp, int x, int size) {
		if(arr[sp] == arr.length) {
			int[] found = new int[size];
			return found;
		}
		if (arr[sp] == x) {
			size++;
		}
		
		int[] b = all(arr, sp + 1, x, size);

		if (arr[sp] == x) {
			b[size-1] = sp;
		}
		return b;

	}
}
