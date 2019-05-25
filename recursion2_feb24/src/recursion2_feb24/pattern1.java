package recursion2_feb24;

public class pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p1(0, 0, 4);
	}

	private static void p1(int row, int column, int n) {
		if (n == 0) {
			return;
		}
		p1(row, column, n - 1);
		System.out.println("*");
		if (column<=n) {
			return;
		}
		p1(row, n-1, n);
		System.out.print("*");
		return;
	}
}
