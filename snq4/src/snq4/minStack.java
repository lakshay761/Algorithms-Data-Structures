package snq4;

public class minStack {
	private int[] data;
	private int[] msf;
	private int cap;
	private int tos;
	private int tosm;
//	private int msf;
	public minStack(int cap) {
		this.data = new int[cap];
		this.cap = cap;
		this.tos = -1;
		this.tosm = -1;
//		this.msf = Integer.MAX_VALUE;
	}
	public void push(int val) {
		if(tos == cap-1) {
			System.out.println("Overflow");
		}
		else {
//			if(val<msf) {
//				msf = val;
//			}
//			if(tosm )
//			tos++;
//			data[tos] = val;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
