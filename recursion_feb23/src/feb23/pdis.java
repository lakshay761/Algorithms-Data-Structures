package feb23;

public class pdis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pdis(5);
	}

	private static void pdis(int n) {
		if (n == 0) {
			return;
		}
		if ((n % 2) != 0) {
			System.out.println(n);
		} 
			pdis(n - 1);
		if((n % 2) == 0){
		System.out.println(n);
	}}
}
