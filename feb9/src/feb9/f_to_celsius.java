package feb9;

public class f_to_celsius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i<=300; i+=20) {
			System.out.print(i + "\t");
			int celsius = (int)((5.0/9) * (i - 32));
			System.out.println(celsius);
		}
	}

}
