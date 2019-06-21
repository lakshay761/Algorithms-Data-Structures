package pqapplication;

import java.util.*;

public class mergelist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		al.add(new ArrayList<>(Arrays.asList(2,5,9,18,20,25)));
		al.add(new ArrayList<>(Arrays.asList(3,7,8,15,22)));
		al.add(new ArrayList<>(Arrays.asList(0,4,6,12)));
		al.add(new ArrayList<>(Arrays.asList(1,10,16,21,28)));
		merge(al);
		
	}

	static class Helper implements Comparable<Helper> {
		int di;
		int li;
		int val;

		Helper(int di, int li, int val) {
			this.di = di;
			this.li = li;
			this.val = val;
		}

		public int compareTo(Helper other) {
			return this.val - other.val;
		}
	}

	public static void merge(ArrayList<ArrayList<Integer>> al) {
		PriorityQueue<Helper> pq = new PriorityQueue<>();
		for (int i = 0; i < al.size(); i++) {
			pq.add(new Helper(0, i, al.get(i).get(0)));
		}

		while (pq.size() > 0) {
			Helper rem = pq.remove();
			System.out.print(rem.val + "->");
			if (rem.di + 1 < al.get(rem.li).size()) {
				pq.add(new Helper(rem.di + 1, rem.li, al.get(rem.li).get(rem.di + 1)));
			}
		}
	}
}
