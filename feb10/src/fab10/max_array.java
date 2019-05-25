package fab10;

public class max_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-10,-20,-30,-40};
		int max = arr[0];
		for(int i=1;i<4;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		System.out.println("The maximum number is " + max);
	}

}
