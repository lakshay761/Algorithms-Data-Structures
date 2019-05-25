package recursion9march;

public class crosswordBoxChoice {

	public static void main(String[] args) {
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
		boolean[] mywusf = new boolean[words.length];
		crossword(myBoard, words, 0, mywusf);
	}

	public static void crossword(char[][] board, String words[], int bno, boolean[] wusf) {
		if (bno == board.length * board.length) {
			return;
		}
		int x = bno / board.length;
		int y = bno % board.length;
		
		for (int i = 0; i < words.length; i++) {
			if (wusf[i] == false) {
				if (cwbpvertical(board, words[i], x, y) == true) {
					wusf[i] = true;
					boolean[] dipit = new boolean[words[i].length()];
					pwvertical(board, words[i], x, y, dipit);
					crossword(board, words, bno + 1, wusf);
					rwvertical(board,words,bno);
					wusf[i] = false;
				}
				else if (cwbphor(words[i], board, bno) == true) {
					wusf[i] = true;
					boolean[] dipit = new boolean[words[wsf].length()];
					pwhor(words[i],board,bno);
					crossword(board, words, bno + 1, wusf);
					rwhor(board,words,bno);
					wusf[i] = false;
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
}
