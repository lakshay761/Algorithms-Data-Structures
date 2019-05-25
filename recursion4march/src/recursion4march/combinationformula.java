package recursion4march;

public class combinationformula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combine(2,4,0,0,"");
	}

	public static void combine(int tq, int tb,int cb,int qpsf, String asf) {
		if (cb == tb) {
			if (qpsf == tq) {
				System.out.println(asf);
			}
			return;
		}

		combine(tq,tb, cb + 1,qpsf+1, asf + " q"+qpsf + "b" + cb);
		combine(tq,tb, cb + 1, qpsf,asf );

	}
}
