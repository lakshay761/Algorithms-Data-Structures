package recursion9march;

public class sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] myBoard = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		sudoku(myBoard, 0);
	}

	public static void sudoku(int[][] board, int bno) {
		if (bno == board.length * board.length) {

			for (int di = 0; di < board.length; di++) {
				for (int dj = 0; dj < board.length; dj++) {
					System.out.print(board[di][dj] + " ");
				}
				System.out.println("");

			}
			System.out.println("");
			System.out.println("");

			return;

		}
		int r = bno / board.length;
		int c = bno % board.length;

		if (board[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				board[r][c] = i;
				if (isNumSafe(board, r, c) == true) {
					sudoku(board, bno + 1);
				}
				board[r][c] = 0;
			}
		} else {
			sudoku(board, bno + 1);
		}
	}

	public static boolean isNumSafe(int[][] board, int row, int column) {
		int target = board[row][column];
		// vertical
		for (int v = 0; v < board.length; v++) {
			if (board[v][column] == target && v != row) {
				return false;
			}
		}
		// horizontal
		for (int h = 0; h < board.length; h++) {
			if (board[row][h] == target && h != column) {
				return false;
			}
		}
		// Box
		//row/n*n gives first index of the submatrix with dimentions n*n
		for (int d1 = row / 3 * 3; d1 < (row / 3 * 3) + 3; d1++) {
			for (int d2 = column / 3 * 3; d2 < (column / 3 * 3) + 3; d2++) {
				if (board[d1][d2] == target && d1 != row && d2 != column) {
					return false;
					
				}
			}
		}

		return true;
	}

}
