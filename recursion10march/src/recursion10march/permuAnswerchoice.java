package recursion10march;

public class permuAnswerchoice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pac("abc", "");
	}

	public static void pac(String q, String a) {
		if (q.length() == 0) {
			System.out.println(a);
			return;
		}
		for (int i = 0; i <= a.length(); i++) {
			// pac(q.substring(0, q.length() - 1), q.charAt(q.length()) + a);
			char c = q.charAt(0);
			String rq = q.substring(1);
			pac(rq, a.substring(0, i) + c + a.substring(i, a.length()));
		}

	}
}