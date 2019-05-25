package recursion3march;

import java.util.ArrayList;

public class maze2ArrLs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gmp2(0,0,2,2));
		
	}

	public static ArrayList<String> gmp2(int cr, int cc, int dr, int dc) {
		if (cr == dr && cc == dc) {
			ArrayList<String> pb = new ArrayList<>();
			pb.add("");
			return pb;
		}
//		if (cr > dr || cc > dc) {
//			ArrayList<String> pb = new ArrayList<>();
//			return pb;
//		}
		ArrayList<String> p = new ArrayList<>();
		//ArrayList<String>[] p1 = new ArrayList[dr-cr];
		
		
		for (int i = 1; i <= (dr - cr); i++) {
			ArrayList<String> p1 = gmp2(cr + i, cc, dr, dc);
			for (int j = 0; j < p1.size(); j++) {
				p.add("V" +i+ p1.get(j));
			}
		}

		for (int i = 1; i <= (dc - cc); i++) {
			ArrayList<String> p2 = gmp2(cr, cc + i, dr, dc);
			for (int j = 0; j < p2.size(); j++) {
				p.add("H" +i+ p2.get(j));
			}
		}

		for (int i = 1; i <= (dr - cr) && i <= (dc - cc); i++) {
			ArrayList<String> p3 = gmp2(cr + i, cc + i, dr, dc);
			for (int j = 0; j < p3.size(); j++) {
				p.add("D" +i+ p3.get(j));
			}
		}

		return p;
	}
}
