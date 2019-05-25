package recursion10march;

public class targetsumString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mylist = { 10, 20, 30, 40, 50, 60, 70 };
		tarsum(mylist,0,70,"");
	}

	public static void tarsum(int[] arr, int idx, int tar, String str) {
		if (idx >= arr.length) {
			if (tar == 0) {
				System.out.println(str);
			}
			return;
		}

		tarsum(arr, idx + 1, tar - arr[idx], str + arr[idx] + " ");
		tarsum(arr, idx + 1, tar, str);
	}
}
