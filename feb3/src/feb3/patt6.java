package feb3;

public class patt6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5;
		int stars = (num/2)+1;
		int spaces = 1;
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=stars;j++) {
				System.out.print("*");
			}
			for(int j=1;j<=spaces;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=stars;j++) {
				System.out.print("*");
			}
			if(i<=num/2){
				stars--;
				spaces +=2;
			}
			else {
				stars++;
				spaces -=2;
			}
			System.out.println();
		}
	}

}
