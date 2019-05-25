package recursion15march;

public class encodings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		encode("1123", "");
	}

	static void encode(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		if (str.length() == 1) {
			encode("", ans + str.charAt(0) + "-");
		} else {
			// 1char , 2char , both
			if (Integer.parseInt(str.substring(0, 2)) >= 26) {
				encode(str.substring(1), ans + str.charAt(0) + "-");
			} else if (str.charAt(1) == '0') {
				encode(str.substring(2), ans + str.substring(0, 2) + "-");
			} else {
				encode(str.substring(1), ans + str.charAt(0) + "-");
				encode(str.substring(2), ans + str.substring(0, 2) + "-");
			}
		}

	}
}
