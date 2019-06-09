package dp1;

public class lowestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcd";
		String s2 = "acbd";
		System.out.println(lcs(s1,s2));
	}
	
	public static int lcs(String s1,String s2) {
		int[][] strg = new int[s1.length()+1][s2.length()+1];
		
		for(int i=0 ; i <strg.length; i++) {
			for(int j = 0; j<strg[0].length ; j++) {
				if(i == 0 || j == 0) {
					strg[i][j] = 0;
				}
				else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					strg[i][j] = 1 + strg[i-1][j-1];
				}
				else {
					strg[i][j] = Math.max(strg[i-1][j], strg[i][j-1]);
				}
			}
		}
		return strg[strg.length-1][strg[0].length-1];
	}
	
	public static void path(String s1,String s2,int[][] strg,int i,int j,String psf) {
		
		if(s1.charAt(i-1) == s1.charAt(j-1)) {
			path(s1, s2, strg, i-1, j-1, psf + s1.charAt(i-1));
		}
	}
}

