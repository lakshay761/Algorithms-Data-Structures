package feb3;

public class patt2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first = 0;
		int second = 1;
		int third = 0;
		for(int i = 1;i<=5;i++) {
			for(int j=1; j<i;j++) {
				System.out.print(first);
				System.out.print(" ");
				third = first + second;
				first = second;
				second = third;
			}
			System.out.println("");
		}
	}

}
