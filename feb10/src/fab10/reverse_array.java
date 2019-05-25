package fab10;

public class reverse_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		int high = arr.length-1;
		for(int i=0;i<3;i++,high--) {
			int temp = arr[i];
			arr[i]= arr[high];
			arr[high] = temp;
		}
		for(int i = 0;i<6;i++) {
			System.out.println( arr[i]);
		}
		
	}

}
