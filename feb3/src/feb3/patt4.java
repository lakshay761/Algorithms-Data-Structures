package feb3;

public class patt4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5;
		for(int i = 1;i<=num;i++) {
			for(int j=1; j<=num;j++) {
				if(i==j || i+j ==num+1)
				System.out.print("*");
				else {
				System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}


