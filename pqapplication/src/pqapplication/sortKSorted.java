package pqapplication;

import java.util.*;

public class sortKSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr = { 20, 40, 10, 30, 50, 80, 60, 90, 70, 120, 100 };
		int k = 2;
		for (int i = 0; i <= k; i++) {
			pq.add(arr[i]);
		}

		for(int i = k+1;i<arr.length;i++) {
			System.out.println(pq.remove());
			pq.add(arr[i]);
		}
		while(pq.size()>0) {
			System.out.println(pq.remove());
		}
	}

}
