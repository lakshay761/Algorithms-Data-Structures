package snq4;

public class kStack {
	private int[] pa;
	private int[] da;
	private int[] sha;
	private int cap;
	private int fh;
	
	kStack(int cap,int k){
		this.cap = cap;
		this.pa = new int[cap];
		this.da = new int[cap];
		this.sha = new int[k];
		this.fh = 0;
		for(int i=0; i<cap;i++) {
			this.da[i] = 0;
			this.pa[i] = i+1;
		}
		for(int i=0;i<k;i++) {
			this.sha[i] = -1;
		}
		this.pa[cap-1] = -1;
	}
	
	public boolean isFull() {
		return fh == -1;
	}
	public boolean isEmpty(int s) {
		return sha[s] == -1;
	}
	
	public void push(int val,int s) {
		if(isFull() == true) {
			System.out.println("Overflow");
			return;
		}
		else {
			int temp = fh;
			fh = pa[temp];
			
			pa[temp] = sha[s];
			sha[s] = temp;
			da[temp] = val;
		}
	}
	public void pop(int s) {
		if(isEmpty(s)) {
			System.out.println("Underflow");
			return;
		}
		else {
			int temp = sha[s];
			sha[s] = pa[temp];
			
			pa[temp] = fh;
			fh = temp;
			da[temp] = 0;
		}
	}
	public int top(int s) {
		if(isEmpty(s)) {
			System.out.println("Underflow");
			return -1;
		}
		else {
			return da[sha[s]];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kStack ks = new kStack(10,3);
		
		ks.push(10, 0);
		ks.push(20, 0);
		ks.push(30, 1);
		ks.push(40, 2);
		ks.push(50, 2);
		ks.push(60, 1);
		ks.push(70, 1);
		ks.push(80, 2);
		ks.push(90, 0);
		ks.push(100, 0);
		ks.push(110, 0);
		
		for(int i = 0;i<=2;i++) {
			System.out.print(i + " :");
			while(ks.isEmpty(i) != true) {
				System.out.print(ks.top(i) + " ");
				ks.pop(i);
			}
			System.out.println();
		}
	}

}
