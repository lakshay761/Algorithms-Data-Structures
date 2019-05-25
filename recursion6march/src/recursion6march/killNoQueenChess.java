package recursion6march;

public class killNoQueenChess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] myboard = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		killnoqueen(myboard, 0, -1, "");
		System.out.println(counter);
	}

	static int counter = 0;

	public static boolean isBoxSafe(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1 && isQueenSafe(board, i, j) == false) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isQueenSafe(int[][] board, int i, int j) {
		// vertical
		for (int row = 0; row < board.length; row++) {
			if ((board[row][j] == 1) && row != i) {
				return false;
			}
		}
		for (int column = 0; column < board.length; column++) {
			if ((board[i][column] == 1) && column != j) {
				return false;
			}
		}
		// daig se
		for (int row = i + 1, column = j + 1; row < board.length && column < board.length; row++, column++) {
			if (board[row][column] == 1) {
				return false;
			}
		}
		// daig sw
		for (int row = i + 1, column = j - 1; row < board.length && column >= 0; row++, column--) {
			if (board[row][column] == 1) {
				return false;
			}
		}
		// daig nw
		for (int row = i - 1, column = j - 1; row >= 0 && column >= 0; row--, column--) {
			if (board[row][column] == 1) {
				return false;
			}
		}
		// daig ne
		for (int row = i - 1, column = j + 1; row >= 0 && column < board.length; row--, column++) {
			if (board[row][column] == 1) {
				return false;
			}
		}
//
//		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };
//
//		for (int r = 1; r < board.length; r++) {
//			for (int d = 0; d < dir.length; d++) {
//				int x = i + r * dir[d][0];
//				int y = j + r * dir[d][1];
//
//				if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 1) {
//					return false;
//				}
//			}

		

//		System.out.println("( " + i + ", " + j + ") ");
		return true;
	}

	public static void killnoqueen(int[][] board, int cq, int pos, String asf) {
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
				killnoqueen(board, cq + 1, x, asf + r + c + " ");
				board[r][c] = 0;
			}
		}
	}
}
