package feb3;

public class patt5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5;
		int spaces = num/2;
		int star = 1;
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=spaces;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=star;j++) {
				System.out.print("*");
			}
			if(i<=num/2){
				spaces--;
				star +=2;
			}
			else {
				spaces++;
				star -=2;
			}
			System.out.println();
		}
	}

}
