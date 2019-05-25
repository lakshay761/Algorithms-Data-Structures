package snq4;

public class twoStack {

	private int[] data;
	private int cap;
	private int tos1;
	private int tos2;

	public twoStack(int cap) {
		this.data = new int[cap];
		this.cap = cap;
		this.tos1 = -1;
		this.tos2 = cap;
	}

	public void push1(int val) {
		if (tos1 + 1 == tos2) {
			System.out.println("Stack Overflow");
		} else {
			tos1++;
			data[tos1] = val;
		}
	}

	public void push2(int val) {
		if (tos2 - 1 == tos1) {
			System.out.println("Stack Overflow");
		} else {
			tos2--;
			data[tos2] = val;
		}
	}

	public int pop1() {
		if (tos1 == -1) {
			System.out.println("Stack Underflow");
			return -1;
		} else {
			int val = data[tos1];
			tos1--;
			return val;
		}
	}

	public int pop2() {
		if (tos2 == cap) {
			System.out.println("Stack Underflow");
			return -1;
		} else {
			int val = data[tos2];
			tos2++;
			return val;
		}
	}

	public int peek1() {
		if (tos1 == -1) {
			System.out.println("Stack Underflow");
			return -1;
		} else {
			int val = data[tos1];
			return val;
		}
	}

	public int peek2() {
		if (tos2 == cap) {
			System.out.println("Stack Underflow");
			return -1;
		} else {
			int val = data[tos2];
			return val;
		}
	}

	public boolean isempty1() {
		if (tos1 == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isempty2() {
		if (tos2 == cap) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (tos1 + 1 == tos2) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		twoStack ts = new twoStack(5);
		ts.push1(10);
		ts.push2(20);
		ts.push2(30);
		ts.push2(40);
		ts.push2(50);
		ts.push2(60);
		while (ts.isempty2() == false) {

			System.out.println(ts.pop1());
			System.out.println(ts.pop2());
		}
	}

}
