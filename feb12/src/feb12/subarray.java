package feb12;

public class subarray {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 6, -1, -12, 3, -4, 19, 5 };
		int max = arr[0];
		// int[] subarr = new int[10];
		int superMax = Integer.MIN_VALUE;
		int clow = 0;
		int chigh = 0;
		int low = 0;
		int high = 0;
		for (int i = 1; i < arr.length; i++) {
			if (max + arr[i] >= arr[i]) {
				max += arr[i];
				chigh++;
			} else {
				max = arr[i];
				clow = i;
				chigh = i;
			}
			if (max > superMax) {
				superMax = max;
				low = clow;
				high = chigh;
			}
		}
		System.out.println(superMax);
		for (int i = low; i <= high; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
