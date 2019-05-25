package feb23;

public class power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2,5));
	}
	private static int pow(int n,int p) {
		if(p==0) {
			return 1;
		}
		return n*pow(n,p-1);
	}
}
