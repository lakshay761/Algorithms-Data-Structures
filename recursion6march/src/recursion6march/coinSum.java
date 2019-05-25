package recursion6march;

public class coinSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myarr = { 2, 3, 5 };
		printcc_comb(myarr, 0, 7, "");
	}

	public static void printcc_comb(int[] arr, int sp, int sum, String asf) {
		if(sum ==0) {
			System.out.println(asf);
			return;
		}
		if(sum<0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			printcc_comb(arr, sp, sum - arr[i], asf + arr[i]);
		}
	}
}
