package feb3;

public class patt1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		for(int i = 1;i<=5;i++) {
			for(int j=1; j<i;j++) {
				counter++;
				System.out.print(counter);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
