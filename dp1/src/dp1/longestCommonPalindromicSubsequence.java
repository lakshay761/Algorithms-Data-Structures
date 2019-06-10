package dp1;

public class longestCommonPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abkccgbc";
//		System.out.println(lcps(str));
//		String s2 = "abgcckyb";
//		System.out.println(ccps(s2));
		lcpstr("abccbc");
	}

	public static int lcps(String str) {
		int[][] strg = new int[str.length()][str.length()];
		for (int gap = 0; gap < strg.length; gap++) {
			for (int i = 0, j = i + gap; j < strg.length; j++, i++) {
				if (i == j) {
					strg[i][j] = 1;
				} else if (str.charAt(i) == str.charAt(j)) {
					strg[i][j] = 2 + strg[i + 1][j - 1];
				} else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j - 1]);
				}
			}
		}
		return strg[0][strg[0].length - 1];
	}

	public static int ccps(String str) {
		int[][] strg = new int[str.length()][str.length()];
		for (int gap = 0; gap < strg.length; gap++) {
			for (int i = 0, j = i + gap; j < strg.length; j++, i++) {
				if (i == j) {
					strg[i][j] = 1;
				} else if (str.charAt(i) == str.charAt(j)) {
					strg[i][j] = strg[i + 1][j] + 1 + strg[i][j - 1];
				} else {
					strg[i][j] = strg[i + 1][j] + strg[i][j - 1] - strg[i+1][j-1];
				}
			}
		}
		return strg[0][strg[0].length - 1];
	}
	public static void lcpstr(String str) {
		boolean[][] strg = new boolean[str.length()][str.length()];
		int maxlen = 0;
		int count = 0;
		for (int gap = 0; gap < strg.length; gap++) {
			for (int i = 0, j = i + gap; j < strg.length; j++, i++) {
				if (i == j) {
					strg[i][j] = true;
					maxlen = gap+1;
					count++;
				}else if(gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = true;
						maxlen = gap+1;
						count++;
					}
				}
				else if (str.charAt(i) == str.charAt(j)) {
					if(strg[i+1][j-1] == true) {
						strg[i][j] = true;
						maxlen = gap+1;
						count++;
					}
					else {
						strg[i][j] = false;
					}
				} else {
					strg[i][j] = false;
				}
			}
		}
		System.out.println(maxlen + " " + count);
	}
}
