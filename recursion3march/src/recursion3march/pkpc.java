package recursion3march;

public class pkpc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pkpc("682", "");
	}

	public static void pkpc(String ques, String asf) {
		String[] codes = { "-", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wx", "yz" };

		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		String total = codes[ques.charAt(0) - '0'];	// pqrs
		String roq = ques.substring(1); // 82

		for (int i = 0; i < total.length(); i++) {
			pkpc(roq, asf + total.charAt(i));		//(82,asf + {p,q,r,s})
		}
	}
}
