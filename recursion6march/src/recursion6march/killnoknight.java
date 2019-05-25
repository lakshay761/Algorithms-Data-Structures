package recursion6march;

public class killnoknight {
	static int counter = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] myboard = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	}
	public static boolean isBoxSafe(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1 && isKnightSafe(board, i, j) == false) {
					return false;
				}
			}
		}

		return true;
	}
	
	public static boolean isKnightSafe(int[][] board,int i,int j) {
	//1
	if(i-2 >= 0 && board[i-2][j-1] == 1) {
		return false;
	}
	//2,3,4,5,6,7,8
	
	
	return true;
	}
	public static void nKnights(int[][] board, int cq, int pos, String asf) {
		// convert into 1D array
		if (cq == board.length) {
			if (isBoxSafe(board) == true) {
				System.out.println(asf);
				System.out.println(counter);
			}
			counter++;

			return;
		}

		for (int x = pos + 1; x < board.length * board[0].length; x++) {
			int r = x / board.length;
			int c = x % board.length;
			if (board[r][c] == 0) {
				board[r][c] = 1;
				nKnights(board, cq + 1, x, asf + r + c + " ");
				board[r][c] = 0;
			}
		}
	}
}


