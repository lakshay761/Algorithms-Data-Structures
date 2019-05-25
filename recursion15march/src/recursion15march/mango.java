package recursion15march;

import java.util.ArrayList;

public class mango {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> vocab = new ArrayList<>();
		vocab.add("man");
		vocab.add("mango");
		vocab.add("go");
		vocab.add("ice");
		vocab.add("cream");
		vocab.add("air");
		vocab.add("plane");
		vocab.add("airplane");
		vocab.add("icecream");
		wordbreak(vocab, "gomanicecreamairplane", "");
	}

	static boolean isWord(ArrayList<String> vocab, String word) {
		//System.out.println("isword");
		for (int x = 0; x < vocab.size(); x++) {
			if (word.compareTo(vocab.get(x)) == 0) {
				return true;
			}
		}
		return false;
	}

	static void wordbreak(ArrayList<String> vocab, String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i <= ques.length(); i++) {
			String prefix = ques.substring(0, i);
			//System.out.println("e" + i + prefix);
			if (isWord(vocab, prefix) == true) {
				//System.out.println("n" + i);
				String rq = ques.substring(i);
				wordbreak(vocab, rq, ans + prefix + "-");
			}
		}
	}

}
