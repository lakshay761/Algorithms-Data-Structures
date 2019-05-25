package recursion2_feb24;

public class power_new {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2, 8));
	}

	private static int pow(int n, int p) {
		if (p == 1) {
			return n;
		}
		int x = (pow(n, p / 2));
		if (p % 2 == 0) {
			return x * x;
		}
		else {
			return x*x*n;
		}
	}
}