package recursion4march;

public class queenboxBitMask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		qpermute(0, 2, "", 2, 5);
	}


	public static void qpermute(int bm, int cq, String asf, int tq, int tb) {
		if (cq == 0) {
			System.out.println(asf);
		}
		for (int k = 0; k < tb; k++) {
			byte num = (byte) (1 << k);
			if((num & (byte)bm) == 0) {
				bm = bm|(num);
				qpermute(bm, cq-1, asf + " " + "q" + cq + " " + "b" + k,tq,tb);
				bm = bm &(~num);
			}
		}
	}
}
