package feb23;

public class recursion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pi(5);
	}
	//static int i = 1;
	private static void pi(int n) {
		if(n == 0) {
			return;
		}
		pi(n-1);
		System.out.println(n);
	}
}
