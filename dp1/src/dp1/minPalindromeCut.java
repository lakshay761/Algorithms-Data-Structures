package dp1;

public class minPalindromeCut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mcp("abccbc"));

	}

	public static int mcp(String str) {
		int[][] strg = new int[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap + i; j < str.length(); j++, i++) {
				if (i == j) {
					strg[i][j] = 0;
				}else if(gap == 1) {
					if(str.charAt(i) == str.charAt(j)) {
						strg[i][j] = 0;
					}
					else {
						strg[i][j] = 1; 
					}
				}
				else if (str.charAt(i) == str.charAt(j) && strg[i + 1][j - 1] == 0) {
					strg[i][j] = 0;
				} else {
					int min = str.length();
					for (int k = 0; k < gap; k++) {
						if(strg[i][j-gap+k] + strg[i+1 + k][j]<min) {
							min = strg[i][j-gap + k] + strg[i+1+k][j];
						}
					}
					strg[i][j] = min+1;
				}
			}
		}
//		for(int i = 0;i<strg.length;i++) {
//			for(int j = 0;j<strg[0].length;j++) {
//				System.out.print();
//			}
//		}
		return strg[0][strg[0].length - 1];
	}
}
