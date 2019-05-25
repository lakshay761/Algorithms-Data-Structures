package recursion9march;

public class crosswordPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] myBoard = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '-', '-', '-', '-', '-', '-', '+', '+' },
				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '-', '-', '-', '-', '-', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };
		String words[] = { "agra", "norway", "england", "gwalior" };
		crossword(myBoard, words, 0);
	}

	public static void crossword(char[][] board, String words[], int wsf) {
		if (wsf >= words.length) {
			for (int di = 0; di < board.length; di++) {
				for (int dj = 0; dj < board.length; dj++) {
					System.out.print(board[di][dj] + " ");
				}
				System.out.println("");
			}
			return;
		}
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board.length; y++) {
				//System.out.println("if crossword");
				if (board[x][y] == '-' || board[x][y] == words[wsf].charAt(0)) {
					
					if (cwbpvertical(board, words[wsf], x, y) == true) {
						boolean[] dipit = new boolean[words[wsf].length()];
						pwvertical(board, words[wsf], x, y, dipit);
						crossword(board, words, wsf + 1);
						rwvertical(board, words[wsf], x, y, dipit);
						
					} else if (cwbphor(board, words[wsf], x, y) == true) {
						boolean[] dipit = new boolean[words[wsf].length()];
						pwhor(board, words[wsf], x, y, dipit);
						crossword(board, words, wsf + 1);
						rwhor(board, words[wsf], x, y, dipit);
					}
				}

			}
		}
	}

	public static boolean cwbpvertical(char[][] board, String word, int x, int y) {
		//System.out.println("cwbpw vertical");
		if (x + word.length() > board.length) {
			// if the word is going after the wall
			return false;
		}

		else if (x > 0 && board[x - 1][y] != '+') {
			// if there is a character other than a plus on left
			return false;
		}

		else if (x + word.length() < board.length && board[x + word.length()][y] != '+') {
			// if there is a character other than a plus on right
			return false;
		} else {
			for (int i = 0; i < word.length(); i++) {
				if (board[x + i][y] != '-' && board[x + i][y] != word.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean cwbphor(char[][] board, String word, int x, int y) {

		if (y + word.length() > board.length) {
			// if the word is going after the wall
			return false;
		}

		else if (y > 0 && board[x][y - 1] != '+') {
			// if there is a character other than a plus on left
			return false;
		}
		//y + word.length() < board.length &&
		else if ( board[x][y + word.length()] != '+') {
			// if there is a character other than a plus on right
			return false;
		}

		else {
			for (int i = 0; i < word.length(); i++) {
				if (board[x][y + i] != '-' && board[x][y + i] != word.charAt(i)) {
					return false;
				}
			}
		}

		return true;
	}

	public static void pwvertical(char[][] board, String word, int x, int y, boolean[] dipit) {
		for (int i = 0; i < word.length(); i++) {
			dipit[i] = board[x + i][y] == '-';
			board[x + i][y] = word.charAt(i);
		}
		//System.out.println("pw vertical");
	}

	public static void pwhor(char[][] board, String word, int x, int y, boolean[] dipit) {
		for (int i = 0; i < word.length(); i++) {
			dipit[i] = board[x][y + i] == '-';
			board[x][y + i] = word.charAt(i);
		}
	}

	public static void rwvertical(char[][] board, String word, int x, int y, boolean[] dipit) {
		for (int i = 0; i < word.length(); i++) {
			if (dipit[i] == true) {
				board[x + i][y] = '-';
			}
		}
	}

	public static void rwhor(char[][] board, String word, int x, int y, boolean[] dipit) {
		for (int i = 0; i < word.length(); i++) {
			if (dipit[i] == true) {
				board[x][y + i] = '-';
			}
		}
	}
}