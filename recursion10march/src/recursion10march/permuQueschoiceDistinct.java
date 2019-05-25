package recursion10march;

public class permuQueschoiceDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pqcd("abab","");
	}

	public static void pqcd(String q, String a) {
		if(q.length()==0) {
			System.out.println(a);
			return;
		}
		
		boolean[] arr = new boolean[256];		//determine if call for that is already made
		for (int i = 0; i < q.length(); i++) {
			char c = q.charAt(i);
			String rq = q.substring(0, i) + q.substring(i+1,q.length());
			if(arr[c] == false) {				
				arr[c] = true;
				pqcd(rq,a+c);
			}
		}
	}
}
