package priorityQImplement;

import java.util.*;
class pq {
	private ArrayList<Integer> arr = new ArrayList<>();
	boolean type;

	pq(boolean type) {
		this.type = type;
	}

	private boolean ishp(int i, int j) {
		if (this.type == true) {
			return arr.get(i) < arr.get(j);
		} else {
			return arr.get(i) > arr.get(j);
		}
	}

	private void swap(int i, int j) {
		int v1 = arr.get(i);
		int v2 = arr.get(j);
		arr.set(i, v2);
		arr.set(j, v1);
	}

	private void upheapify(int i) {
		int pi = (i - 1) / 2;
		if (ishp(i, pi)) {
			swap(i, pi);
			upheapify(pi);
		}
	}

	public void add(int val) {
		arr.add(val);
		upheapify(arr.size() - 1);
	}

	private void downheapify(int i) {
		int li = 2 * i + 1;
		int ri = 2 * i + 2;
		int hp = i;
		if (arr.size() > li && ishp(li, hp)) {
			hp = li;
		}
		if (arr.size() > ri && ishp(ri, hp)) {
			hp = ri;
		}
		if (i != hp) {
			swap(i, hp);
			downheapify(hp);
		}
	}

	public void remove() {
		swap(arr.size() - 1, 0);
		arr.remove(arr.size() - 1);
		downheapify(0);
	}

	public int peek() {
		return arr.get(0);
	}

	public int size() {
		return arr.size();
	}
}


public class PriorityImplement1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pq q = new pq(true);
		for(int i = 1 ;i<10 ; i++) {
			q.add(i);
		}
		for(int i = 1 ;i<10 ; i++) {
			System.out.print(q.peek() + " - ");
			q.remove();
		}
	}

}
