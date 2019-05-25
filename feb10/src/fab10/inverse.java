package fab10;

public class inverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,4,1,0,3};
		int[] inv = new int[arr.length];
		for(int i=0;i<5;i++) {
			inv[arr[i]] = i;
		}
		for(int i =0;i<5;i++) {
			System.out.print(" "+inv[i]);
		}
	}

}
