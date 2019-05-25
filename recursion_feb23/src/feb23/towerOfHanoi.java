package feb23;

public class towerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toh('s','d','h',3);
	}
	private static void toh(char s,char d,char h, int n) {
		if(n == 0 ) {
			return;
		}
		toh(s,h,d,n-1);
		System.out.println( n + "" + s + "" + d);
		toh(h,d,s,n-1);
	}
}
