package feb3;

public class patt7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 9;
		int spaces = num / 2;
		int star = 1;
		int row = 1;
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= spaces; j++) {
				System.out.print(" ");
			}
			for (int j = 1, counter = row; j <= star; j++) {

				System.out.print(counter);
				if (j <= star / 2) {
					counter++;
				} else {
					counter--;
				}
			}
			if (i <= num / 2) {
				spaces--;
				star += 2;
				row++;
			} else {
				spaces++;
				star -= 2;
				row--;
			}
			System.out.println();
		}
	}

}
