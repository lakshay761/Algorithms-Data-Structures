package pqapplication;
import java.util.Collections;
import java.util.PriorityQueue;
public class medianPq {
	static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> right = new PriorityQueue<>();
	public static void add(int x) {
		if(right.size()==0) {
			right.add(x);
		}
		else if(left.size()==0) {
			left.add(x);
		}
		else if(x<left.peek()) {
			left.add(x);
		}else {
			right.add(x);
		}
		if(left.size() - right.size() >=2 || left.size() - right.size()<=-2) {
			rebalance();
		}
	}
	public static int peek() {
		if(right.size() >= left.size()) {
			return right.peek();
		}else {
			return left.peek();
		}
	}
	public static void rebalance(){
		if(left.size()<right.size()) {
			int rem = right.remove();
			left.add(rem);
		}else {
			int rem = left.remove();
			right.add(rem);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {50,10,80,0,20,90,100,5,70,40};
		for(int a:arr) {
			add(a);
			System.out.print(peek()+" ");
		}
	}

}
