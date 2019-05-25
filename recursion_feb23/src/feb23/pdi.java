package feb23;

public class pdi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pdi(5);
	}

	private static void pdi(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		pdi(n - 1);
		//System.out.println(n);
	}
}
