package recursion3march;

public class maze1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pmp1(0, 0, 5, 5, "");
	}
	
	public static void pmp1(int cr, int cc, int dr, int dc, String psf) {	//print maze path 1 pyada
		if (cr == dr && cc == dc) {
			System.out.println(psf);
			return;
		}
		if(cr>dr||cc>dc) {
			return;
		}

		pmp1(cr + 1, cc, dr, dc, psf+'V');

		pmp1(cr, cc + 1, dr, dc, psf+'H');
		
	}
}
