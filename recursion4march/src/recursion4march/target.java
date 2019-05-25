package recursion4march;

import java.util.ArrayList;

public class target {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<Integer> mylist = new ArrayList<>();
//		mylist.add(10);
//		mylist.add(20);
//		mylist.add(30);
//		mylist.add(40);
//		mylist.add(50);
		int[] mylist = { 10, 20, 30, 40, 50, 60, 70 };
		System.out.println(target(mylist, 70, 0));
	}

	public static ArrayList<ArrayList<Integer>> target(int[] ar, int t, int sp) {
		
		if (sp == ar.length) {
			ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
			if (t == 0) {
				totalList.add(new ArrayList<>()); // totalList.add("[]);

			}
			return totalList;
		}
		ArrayList<ArrayList<Integer>> rr1 = target(ar, t - ar[sp], sp + 1);
		ArrayList<ArrayList<Integer>> rr2 = target(ar, t, sp + 1);
		ArrayList<ArrayList<Integer>> mList = new ArrayList<>();
		for (int i = 0; i < rr1.size(); i++) {
			rr1.get(i).add(ar[sp]);
			mList.add(rr1.get(i));
		}
		for (int i = 0; i < rr2.size(); i++) {
			mList.add(rr2.get(i));
		}
		return mList;
	}
}
