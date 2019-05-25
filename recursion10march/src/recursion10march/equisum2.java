package recursion10march;

import java.util.ArrayList;

public class equisum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mylist = { 10, 20, 30, 40, 50, 60, 70 };
		ArrayList<Integer> mys1 = new ArrayList<>();
		ArrayList<Integer> mys2 = new ArrayList<>();
		es(mylist, 0, mys1, 0, mys2, 0);
	}

	public static void es(int[] arr, int id, ArrayList<Integer> s1, int sos1, ArrayList<Integer> s2, int sos2) {
		if (id == arr.length) {
			if (sos1 == sos2) {
				System.out.println("S1 -" + s1 + " S2 -" + s2);
			}
			return;
		}
		s1.add(arr[id]);
		es(arr, id + 1, s1, sos1 + arr[id], s2, sos2);
		s1.remove(s1.size() - 1);
		if (id != 0) {
			s2.add(arr[id]);
			es(arr, id + 1, s1, sos1, s2, sos2 + arr[id]);
			s2.remove(s2.size() - 1);
		}
	}
}
