
public class BST {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private int size;
	private Node root;

	public int size() {
		return this.size;
	}

	public BST(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int si, int ei) {
		if (si > ei)
			return null;
		int mid = (si + ei) / 2;
		Node node = new Node();
		this.size++;
		node.data = sa[mid];
		node.left = construct(sa, si, mid - 1);
		node.right = construct(sa, mid + 1, ei);
		return node;

	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null)
			return false;
		boolean f = false;
		if (data < node.data)
			f = find(node.left, data);
		else if (data > node.data)
			f = find(node.right, data);
		else if (data == node.data)
			return true;
		return f;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node.right == null)
			return node.data;
		else
			return max(node.right);
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null)
			return;
		String str = "";
		if (node.left == null)
			str += ". <= ";
		else
			str += node.left.data + " <= ";
		str += node.data + " => ";
		if (node.right == null)
			str += ".";
		else
			str += node.right.data;
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public void addElement(int data) {
		this.root = addElement(root, data);
	}

	private Node addElement(Node node, int data) {
		if (node == null) {
			node = new Node();
			node.data = data;
			this.size++;
			return node;
		}
		if (node.data > data)
			node.left = addElement(node.left, data);
		if (node.data < data)
			node.right = addElement(node.right, data);
		return node;
	}

	public void removeElement(int data) {
		this.root = removeElement(root, data);
	}

	private Node removeElement(Node node, int data) {
		if (node.data > data)
			node.left = removeElement(node.left, data);
		else if (node.data < data)
			node.right = removeElement(node.right, data);

		else {
			if (node.left == null || node.right == null) {
				node = node.left != null ? node.left : node.right;
			} else {
				int lmax = this.max(node.left);
				node.data = lmax;
				node.left = this.removeElement(node.left, lmax);
			}
		}

		return node;
	}

	public static int CBST(int n) {
		int c = 0;
		if (n == 0 || n == 1) {
			c++;
		} else {
			for (int i = 0; i < n; i++) {
				c += CBST(i) * CBST(n - i - 1);
			}
		}
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = { 12, 25, 37, 50, 62, 75, 87 };
		BST b1 = new BST(a1);
		b1.display();
		b1.addElement(30);
		b1.display();
		b1.removeElement(30);
		b1.display();
		System.out.println(CBST(4));
	}

}
