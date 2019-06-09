package dp1;

public class rodCut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cut = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		System.out.println(MaxCutCost2(cut, 8));
	}

	public static int MaxCutCost(int[] p, int cap) {
		int[] strg = new int[cap + 1];
		strg[0] = 0;
		for (int i = 1; i <= cap; i++) {
			for (int j = 0; j < p.length; j++) {
				if (j <= i) {

					strg[i] = Math.max(strg[i - j] + p[j], strg[i]);
				}
			}
		}
		return strg[strg.length - 1];
	}

	// metthod 2
	public static int MaxCutCost2(int[] p, int cap) {
		int[] strg = new int[cap +1];
		strg[0] = 0;
		for (int i = 1; i <= cap; i++) {
			strg[i] = p[i];
			int left = 0;
			int right = i;
			while (left <= right) {
				strg[i] = Math.max(strg[left] + strg[right], strg[i]);

				left++;
				right--;
			}
		}
		return strg[strg.length - 1];
	}
}
