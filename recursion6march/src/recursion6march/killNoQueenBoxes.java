package recursion6march;

public class killNoQueenBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] myboard = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		knqb(myboard, 0, 0, "");

	}

	static int counter = 1;

	public static void knqb(int[][] board, int cq, int cb, String asf) {
		if (cq == board.length) {
			if (isBoxSafe(board) == true) {
				System.out.println(asf);
				System.out.println(counter);
			}
			counter++;
			return;
		}
		if (cb == board.length * board.length) {
			return;
		}

		int r = cb / board.length;
		int c = cb % board.length;
		board[r][c] = 1;
		knqb(board, cq + 1, cb + 1, asf + r + c + " ");
		board[r][c] = 0;
		knqb(board, cq, cb + 1, asf);
	}

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

		return true;
	}

}
