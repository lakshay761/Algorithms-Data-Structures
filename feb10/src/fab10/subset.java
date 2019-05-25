package fab10;

public class subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30 };
		for (int i = 0; i < (1	 << arr.length); i++) {
			for (int j = arr.length-1,k=0; j >=0; j--,k++) {
				int bm = 1 << j;
				if ((i & bm) == bm) {
					System.out.print(" " + arr[k]);
				}
				else {
					System.out.print("  *");
				}
			}
			System.out.println();
		}
	}

}
