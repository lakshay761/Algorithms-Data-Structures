package feb19;

public class mat_multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] one = {
				{10,0,0},
				{0,10,1},
		};
		int[][] two = {
				{1,0,1,0},
				{0,1,1,1},
				{1,1,1,1}
		};
		int r1 = one.length;
		int c1 = one[0].length;
		int r2 = two.length;
		int c2 = two[0].length;
		
		int[][] prod = new int[r1][c2];
		for(int i=0; i<r1; i++) {
			for(int j=0; j<c2 ;j++) {
				prod[i][j]=0;
				for(int k =0;k<c1;k++) {
					prod[i][j] += one[i][k]* two[k][j]; 
				}
			}
		}
		
		for(int i=0; i<r1; i++) {
			for(int j=0; j<c2 ;j++) {
				System.out.print(prod[i][j] + " ");
			}
	}
	}
}

