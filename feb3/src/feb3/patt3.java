package feb3;

public class patt3 {

	public static void main(String[] args) {
	
		for(int i = 0;i<=5;i++) {
			int next = 1;
			
			for(int j=0; j<=i;j++) {
				System.out.print(next);
				System.out.print(" ");
				next = ((next * (i-j))/(j+1)); 
			}
			System.out.println("");
		}
	}
	

}
