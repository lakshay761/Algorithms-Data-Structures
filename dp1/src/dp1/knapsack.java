package dp1;

public class knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {2,5,1,3,4};
		int[] p = {15,14,10,45,30};
		System.out.println(unb(w, p, 7));
	}

	public static int zeroOne(int[] w, int[] p, int cap) {
		int[][] strg = new int[w.length + 1][cap + 1];
		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
				} else {
					if (w[i-1] <= j) {
						strg[i][j] = Math.max(strg[i - 1][j], (strg[i - 1][j- w[i - 1]] + p[i - 1]));
					}
					else {
						strg[i][j] = strg[i-1][j];
					}
				}
			}
		}
		return strg[strg.length - 1][strg[0].length - 1];
	}
	public static int unb(int[] w,int[] p,int cap) {
		int[] strg = new int[cap+1];
		strg[0] = 0;
		for(int i = 1;i<=cap;i++) {
			for(int j = 0; j<w.length;j++ ) {
				if(w[j] <= i) {
					
					strg[i] = Math.max(strg[i  - w[j]] + p[j],strg[i]);
				}
			}
		}
		
		return strg[strg.length-1];
	}
	
	
}
