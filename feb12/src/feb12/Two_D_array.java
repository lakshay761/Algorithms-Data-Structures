package feb12;

public class Two_D_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 11, 12, 13, 14, 15 }, { 21, 22, 23, 24, 25 }, { 31, 32, 33, 34, 35 },
				{ 41, 42, 43, 44, 45 } };
		boolean flag = true;
		int i = 0;
		for (int c = 0; c < mat[0].length; c++) {	
			for (int r = 0 ; r < mat.length; r++) {
				System.out.print(mat[i][c] + " ");
				if(flag == true) {
					i++;
				}
				else if(flag == false){
					i--;
				}
			}
			if(flag == false) {
				flag = true;
				i = 0;
			}
			else if(flag == true){
				flag = false;
				i = mat.length-1;
			}
		}
	}

}
