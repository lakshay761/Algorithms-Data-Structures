package recursion15march;

public class crypto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "send";
		String s2 = "more";
		String s3 = "money";
		String qs = "";
		boolean[] susf = new boolean[26];
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if (susf[ch - 97] == false) {
				susf[ch - 97] = true;
				qs += ch;
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			if (susf[ch - 97] == false) {
				susf[ch - 97] = true;
				qs += ch;
			}
		}
		for (int i = 0; i < s3.length(); i++) {
			char ch = s3.charAt(i);
			if (susf[ch - 97] == false) {
				susf[ch - 97] = true;
				qs += ch;
			}
		}
		System.out.println(s1 + "  " + s2 + " " + s3 + " " + qs);
		int[] mymap = new int[26];
		boolean[] dusf = new boolean[10];
		crypt(s1, s2, s3, qs, mymap, dusf);
	}

	static int count = 0;

	public static int eval(String a, int[] map) {
		int res = 0;
		int x = 1;
		for (int j = a.length() - 1; j >= 0; j--) {
			res += (map[a.charAt(j) - 97]) * x;
			x *= 10;
		}
		return res;
	}

	public static void crypt(String s1, String s2, String s3, String qs, int[] map, boolean[] dusf) {
		if (qs.length() == 0) {
			int nsf1 = eval(s1, map);
			int nsf2 = eval(s2, map);
			int nsf3 = eval(s3, map);
			if (nsf1 + nsf2 == nsf3) {
				count++;
				System.out.println("------" + count);
				System.out.println(nsf1);
				System.out.println(nsf2);
				System.out.println(" = ");
				System.out.println(nsf3);
			}
			return;
		}
		char ch = qs.charAt(0);
		String rqs = qs.substring(1);

		for (int i = 0; i < 10; i++) {
			if (dusf[i] == false) {
				dusf[i] = true;
				map[ch - 97] = i;
				crypt(s1, s2, s3, rqs, map, dusf);
				dusf[i] = false;
				map[ch - 97] = -1;
			}
		}
	}
}
