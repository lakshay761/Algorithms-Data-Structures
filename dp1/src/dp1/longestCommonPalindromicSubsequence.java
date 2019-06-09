package dp1;

public class longestCommonPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abkccgbc";
		System.out.println(lcps(str));
	}
	public static int lcps(String str) {
		int[][] strg = new int[str.length()][str.length()];
		for(int gap =0; gap<strg.length;gap++) {
//			int gap = 0;
			for(int i=0, j = i+gap ;j<strg.length; j++,i++) {
				if(i==j) {
					strg[i][j] = 1;
				}
				else if(str.charAt(i) == str.charAt(j)) {
					strg[i][j] = 2 + strg[i+1][j-1];
				}
				else {
					strg[i][j] = Math.max(strg[i+1][j], strg[i][j-1]);
				}
			}
			
		}
		return strg[0][strg[0].length-1];
	}
}
