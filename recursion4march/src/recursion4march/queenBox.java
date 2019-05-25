package recursion4march;

public class queenBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myarr = { 0, 0, 0, 0, 0 };
		qpermute(2, 5, myarr, "");
	}

	public static void qpermute(int cq, int tb, int[] arr, String asf) {
		if (cq == 0) {
			System.out.println(asf);
		}

		for (int i = 0; i < tb; i++) {
			if (arr[i] == 0) {
				arr[i] = 1;
				qpermute(cq - 1, tb, arr, asf + " " + "q" + cq + " " + "b" + i);
				arr[i] = 0;
			}
		}
	}
}
