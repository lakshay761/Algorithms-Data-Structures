package recursion4march;

public class queenBox2Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myarr = {0,0,0,0,0};
		qcombine(2,5,myarr,0,"");
	}

	public static void qcombine(int cq, int tb, int[] arr,int id, String asf) {
		if (cq == 0) {
			System.out.println(asf);
		}

		
		for (int i = id; i < tb; i++) {
			if (arr[i] == 0) {
				arr[i] = 1;
				qcombine(cq - 1, tb, arr, i,asf + " " + "q" + cq + " " + "b" + i);
				arr[i] = 0;
			}
		}
	}
}
