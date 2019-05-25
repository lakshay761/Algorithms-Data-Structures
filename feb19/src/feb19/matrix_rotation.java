package feb19;

public class matrix_rotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][]  arr= {
				{'a','b','c','d'},
				{'e','f','g','h'},
				{'i','j','k','l'},
				{'m','n','o','p'}
		};
		// transpose
		for(int i=0;i<arr.length;i++) {
			for(int j= i;j<arr[0].length;j++) {
				char temp = arr[i][j] ;
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		for(int i=0;i<arr.length;i++) {
			int l =0;
			int r =arr[0].length - 1;
			while( l<=r) {
				char temp = arr[i][l];
				arr[i][l] = arr[i][r];
				arr[i][r] = temp;
				l++;
				r--;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j= 0;j<arr[0].length;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
