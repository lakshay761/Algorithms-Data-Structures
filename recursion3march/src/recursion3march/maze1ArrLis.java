package recursion3march;

import java.util.ArrayList;

public class maze1ArrLis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gmp1(0,0,3,3));
	}
	public static ArrayList<String> gmp1(int cr, int cc, int dr, int dc) {
		if (cr == dr && cc == dc) {
			ArrayList<String> pb = new ArrayList<>();
			pb.add("");
			return pb;
		}
		if(cr>dr||cc>dc) {
			ArrayList<String> pb = new ArrayList<>();
			return pb;
		}
		
		ArrayList<String> p1 = gmp1(cr + 1, cc, dr, dc);
		ArrayList<String> p2 = gmp1(cr, cc + 1, dr, dc);
		ArrayList<String> p = new ArrayList<>();
		
		for(int i=0;i< p1.size();i++) {
			p.add("V" + p1.get(i));
		}
		for(int i=0;i< p2.size();i++) {
			p.add("H" + p2.get(i));
		}
		return p;
	}
}
