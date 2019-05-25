package snq4;

public class petrolPumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] o1 = { 6, 4, 8, 2, 3, 3, 1, 7, 2 };
		int[] d1 = { 5, 5, 2, 4, 4, 6, 2, 7, 1 };
		int[] o2 = { 5};
		int[] d2 = { 6};
		
		pp(o2,d2);
	}

	public static void pp(int[] o, int[] d) {
		int so = 0;
		int sp = 0;
		int ep = 0;
		while (true) {
			if (so + o[ep] - d[ep] >= 0) {
				so = so + o[ep] - d[ep];
				ep= (ep+1)%o.length;
				if(sp == ep) {
					System.out.println(sp);
					break;
				}
			} else {
				if(ep<sp) {
					System.out.println("no solution");
					break;
				}
				so = 0;
				sp = ep+1 %o.length;
				ep = sp;
			}
		}
	}
}
