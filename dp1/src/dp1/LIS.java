package dp1;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,10,22,9,33,21,50,41,60,80,1};
		longestIncreaseSubsequence(arr);
	}
	public static void longestIncreaseSubsequence(int[] arr) {
		int[] strg = new int[arr.length];
		strg[0] = 0;
		int id = -1;
		int ans = Integer.MIN_VALUE;
		for(int i=1 ; i<strg.length; i++) {
			int max = 0;
			for(int j=1; j <= i;j++) {
				if(arr[i-j] < arr[i]) {
					if(strg[i-j] > max) {
						max = strg[i-j];
					}
				}
			}
			strg[i] = max+1;
			if(strg[i]>ans) {
				ans = strg[i];
				id = i;
			}
		}
		System.out.println(ans);
		
//		printPath(strg,ans, );
	}
	public static void printPath(int[] arr,int[] strg,int max ,int i,String psf) {
		if(i == 0) {
			return;
		}
		
		for(int j=0;j<i;j++) {
			if(arr[j] < arr[i]) {
				if(strg[j] == strg[i-1]) {
					printPath(arr, strg, max, i, psf);
				}
			}
		}
	}
}
