package recursion3march;

public class maze2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pmp2(0, 0, 4, 4, "");
	}

	public static void pmp2(int cr, int cc, int dr, int dc, String psf) {//print maze path 2 queen
		if (cr == dr && cc == dc) {
			System.out.println(psf);
			return;
		}
		
		for (int i = 1; i <= (dr - cr); i++) {
			pmp2(cr + i, cc, dr, dc, psf + 'V');
		}
		for (int j = 1; j <= (dc - cc); j++) {
			pmp2(cr, cc + j, dr, dc, psf + 'H');
		}
		for (int k = 1; k <= (dr - cr) && k <= (dc - cc); k++) {
			pmp2(cr + k, cc + k, dr, dc, psf + 'D');
		}
	}
}
