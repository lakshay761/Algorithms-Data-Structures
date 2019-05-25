package feb12;

public class twoD_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 11, 12, 13, 14, 15 }, { 21, 22, 23, 24, 25 }, { 31, 32, 33, 34, 35 },
				{ 41, 42, 43, 44, 45 } };
		for (int c = 0; c < mat[0].length; c++) {
		if(c%2 == 0) {	 
			for (int r = 0 ; r < mat.length; r++) {
				System.out.print(mat[r][c] + " ");
			}
		}
		else {
			for (int r = mat.length-1; r >= 0; r--) {
				System.out.print(mat[r][c] + " ");
			}
		}
	}}

}
