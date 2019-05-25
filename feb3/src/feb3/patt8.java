package feb3;

public class patt8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,7,3,4,5};
		int max = arr[0];
		for(int i=1;i<4; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		for(int i=1;i<=max;i++) {
			System.out.println();
			for(int j=0;j<5;j++) {
				if(i >= max-arr[j] + 1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
		}
		
	}

}
