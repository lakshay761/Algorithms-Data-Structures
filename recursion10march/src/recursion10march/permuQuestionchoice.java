package recursion10march;

public class permuQuestionchoice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pqc("abc","");
	}
	public static void pqc(String q,String a) {
	if(q.length()==0) {
		System.out.println(a);
		return;
	}
	
		
		for(int i=0;i<q.length();i++) {			
			pqc(q.substring(0,i) + q.substring(i+1,q.length()), a+ q.charAt(i));
		}
	}
}
