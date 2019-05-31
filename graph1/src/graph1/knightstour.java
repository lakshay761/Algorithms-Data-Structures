package graph1;

public class knightstour {
	public static boolean isValid(int[][] chess, int row, int col) {
		if (row < 0 || row >= chess.length || col < 0 || col >= chess.length) {
			return false;
		} else if (chess[row][col] != -1) {
			return false;
		} else {
			return true;
		}
	}
	static int count = 1;
	public static void knights(int[][] chess, int row, int col, int moves) {
		if (moves == chess.length * chess.length - 1) {
			chess[row][col] = moves;
			System.out.println("*********" +count+"*********");
			for (int i = 0; i < chess.length; i++) {
				for (int j = 0; j < chess.length; j++) {
					System.out.print(chess[i][j] + "	");
				}
				System.out.println();
			}
			System.out.println("******************");
			count++;
			chess[row][col] = -1;
			return;
		}

		chess[row][col] = moves;
		if (isValid(chess, row - 2, col + 1)) {
			knights(chess, row - 2, col + 1, moves + 1);
		}
		if (isValid(chess, row - 1, col + 2)) {
			knights(chess, row - 1, col + 2, moves + 1);
		}
		if (isValid(chess, row + 2, col + 1)) {
			knights(chess, row + 2, col + 1, moves + 1);
		}
		if (isValid(chess, row + 1, col + 2)) {
			knights(chess, row + 1, col + 2, moves + 1);
		}
		if (isValid(chess, row + 2, col - 1)) {
			knights(chess, row + 2, col - 1, moves + 1);
		}
		if (isValid(chess, row + 1, col - 2)) {
			knights(chess, row + 1, col - 2, moves + 1);
		}
		if (isValid(chess, row - 2, col - 1)) {
			knights(chess, row - 2, col - 1, moves + 1);
		}
		if (isValid(chess, row - 1, col - 2)) {
			knights(chess, row - 1, col - 2, moves + 1);
		}
		chess[row][col] = -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] chess = new int[5][5];
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				chess[i][j] =-1;
//				System.out.print(chess[i][j]);
			}
//			System.out.println();
		}
		knights(chess, 1, 1, 0);
	}

}
