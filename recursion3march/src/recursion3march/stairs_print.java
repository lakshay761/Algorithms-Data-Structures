package recursion3march;

public class stairs_print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stairs(7, "");
	}

	public static void stairs(int n, String psf) {
		if (n == 0) {
			System.out.println(psf);
			return;
		}
		if(n<0) {
			return;
		}
		stairs(n - 1, psf + "1");

		stairs(n - 2, psf + "2");

		stairs(n - 3, psf + "3");
	}
}
