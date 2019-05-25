package feb19;

public class exitPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 0, 0, 1, 0 },
				{ 1, 0, 0, 0 },
				{ 0, 0, 0, 0 },
				{ 1, 0, 1, 0 } };
		int i = 0;
		int j = 0;
		char dir = 'E';
		// alternate way to define directions 
		// dir = 0,1,2,3;  as E,S,W,N;
		//dir = (dir + arr[i][j]) %4;
		while (i <= 3 && j <= 3 && i>=0 && j>=0) {
			if (dir == 'E') {
				if (mat[i][j] == 0) {
					j++;
				}
				else if (mat[i][j] == 1) {
					dir = 'S';
					i++;
				}
			} else if (dir == 'S') {
				if (mat[i][j] == 0) {
					i++;
				}
				else if (mat[i][j] == 1) {
					dir = 'W';
					j--;
				}
			} else if (dir == 'W') {
				if (mat[i][j] == 0) {
					j--;
				}
				else if (mat[i][j] == 1) {
					dir = 'N';
					i--;
				}
			} else if (dir == 'N') {
				if (mat[i][j] == 0) {
					i--;
				}
				else if (mat[i][j] == 1) {
					dir = 'E';
					j++;
				}
			}
		}
		if( dir == 'E') {
			j--;
		}
		else if(dir == 'W') {
			j++;
		}
		else if(dir == 'S') {
			i--;
		}
		else if(dir == 'N') {
			i++;
		}
		System.out.println("The positions are " + i + " " + j);
	}

}
