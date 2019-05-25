

public class avl {

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

//	public BST(int[] sa) {
//		root = construct(sa, 0, sa.length - 1);
//	}

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

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
