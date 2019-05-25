package recursion3march;

public class getSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pss("abc","");
	}
	public static void pss(String ques,String asf) {
		if(ques.length()==0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);	//a
		String roq = ques.substring(1); //bc
		
		pss(roq,asf+ch);
		pss(roq,asf+"-");
	}
}
