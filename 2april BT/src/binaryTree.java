import java.util.*;

public class binaryTree {
	private static class Node {
		private int data;
		private Node left;
		private Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node construct(int[] arr) {
		Node root = new Node(arr[0]);
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(root);
		for (int i = 1; i < arr.length; i++) {
			Node fr = stack.getFirst();
			if (arr[i] == -1) {
				stack.removeFirst();
			} else {
				if (fr.left == null) {
					Node nn = new Node(arr[i]);
					fr.left = nn;
					stack.push(nn);
				} else {
					Node nn = new Node(arr[i]);
					fr.right = nn;
					stack.push(nn);
				}
			}
		}
		return root;
	}

	public static void display(Node n1) {
		if (n1 == null) {
			return;
		}
		String s1 = n1.data + "";

		if (n1.left != null) {
			s1 = n1.left.data + "<-" + s1;
		} else {
			s1 = "." + "<-" + s1;
		}
		if (n1.right != null) {
			s1 = s1 + "->" + n1.right.data;
		} else {
			s1 = s1 + "->" + ".";
		}
		// String s1 = n1.left.data + "<-" + n1.data + "->" + n1.right.data;

		System.out.println(s1);
		display(n1.left);
		display(n1.right);

	}

	public static int size(Node root) {
		if (root == null) {
			return 0;
		}
		int ls = size(root.left);
		int rs = size(root.right);
		return ls + rs + 1;
	}

	public static int max(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int m = root.data;
		int lm = max(root.left);
		if (lm > m) {
			m = lm;
		}
		int rm = max(root.right);
		if (rm > m) {
			m = rm;
		}
		return m;
	}

	public static int sum(Node root) {
		if (root == null) {
			return 0;
		}
		int ls = sum(root.left);
		int rs = sum(root.right);
		return ls + rs + root.data;
	}

	public static int height(Node root) {
		if (root == null) {
			return 0;
		}
		int h = 0;
		int lh = height(root.left);
		if (lh > h) {
			h = lh;
		}
		int rh = height(root.right);
		if (rh > h) {
			h = rh;
		}
		return h + 1;
	}

	public static boolean find(Node root, int dtf) {
		if (root == null) {
			return false;
		}
		if (root.data == dtf) {
			return true;
		}

		if (find(root.left, dtf) || find(root.right, dtf)) {
			return true;
		}
		return false;
	}

	public static ArrayList<Integer> n2rp(Node root, int data) {
		if (root == null) {
			return new ArrayList<>();
		}
		if (root.data == data) {
			ArrayList<Integer> fl = new ArrayList<>();
			fl.add(root.data);
			return fl;
		}
		ArrayList<Integer> Ll = n2rp(root.left, data);
		ArrayList<Integer> Rl = n2rp(root.right, data);
		if (Ll.size() != 0) {
			Ll.add(root.data);
			return Ll;
		} else if (Rl.size() != 0) {
			Rl.add(root.data);
			return Rl;
		}
		return new ArrayList<>();

	}

	public static void Kdown(Node root, Node phb, int k) {
		if (root == null || root == phb) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
		}
		Kdown(root.left, phb, k - 1);
		Kdown(root.right, phb, k - 1);
	}

	public static ArrayList<Node> n2rp2(Node root, int data) {
		if (root == null) {
			return new ArrayList<>();
		}
		if (root.data == data) {
			ArrayList<Node> fl = new ArrayList<>();
			fl.add(root);
			return fl;
		}

		ArrayList<Node> Ll = n2rp2(root.left, data);
		ArrayList<Node> Rl = n2rp2(root.right, data);
		if (Ll.size() != 0) {
			Ll.add(root);
			return Ll;
		} else if (Rl.size() != 0) {
			Rl.add(root);
			return Rl;
		}
		return new ArrayList<>();

	}

	public static void kfar(Node root, int data, int k) {
		if (root == null) {
			return;
		}
		ArrayList<Node> path = n2rp2(root, data);
		for (int i = 0; i <= k && i < path.size(); i++) {

			if (i == 0) {
				Kdown(path.get(i), null, k - i);
			} else {
				Kdown(path.get(i), path.get(i - 1), k - i);
			}
		}
	}

	public static void removeLeaves(Node root) {
		if (root == null) {
			return;
		}
		if (root.left.right == null && root.left.left == null) {
			root.left = null;
		}
		if (root.right.right == null && root.right.left == null) {
			root.right = null;
		}
		removeLeaves(root.left);
		removeLeaves(root.right);
	}

	public static Node removeleaves2(Node root) {
		if (root == null) {
			return null;
		}
		if (root.right == null && root.left == null) {
			return null;
		}
		root.left = removeleaves2(root.left);
		root.right = removeleaves2(root.right);
		return root;
	}

	public static void psc(Node root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right != null) {
			System.out.println(root.right.data);
		}

		if (root.right == null && root.left != null) {
			System.out.println(root.left.data);
		}
		psc(root.left);
		psc(root.right);
	}

	public static void pir(Node t, Node root, int low, int hi) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			ArrayList<Integer> path = n2rp(t, root.data);
			int sum = 0;
			for (int i = 0; i < path.size(); i++) {
				sum += path.get(i);
			}
			if (sum < hi && sum > low)
				System.out.println(path);
		}
		pir(t, root.left, low, hi);
		pir(t, root.right, low, hi);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
		int[] arr2 = { 1, 2, 4, -1, 5, 6, 8, 20, 22, -1, -1, 21, -1, -1, 9, 12, 14, -1, 15, 18, -1, 19, -1, -1, -1, 13,
				-1, -1, -1, 7, 10, -1, 11, 16, -1, 17, -1, -1, -1, -1, -1, 3, -1, -1 };
		Node t = construct(arr);
		display(t);
		System.out.println(size(t));
		System.out.println(max(t));
		System.out.println(sum(t));
		System.out.println(height(t));
		System.out.println(find(t, 75));
		System.out.println(n2rp(t, 30));
//		Kdown(t,null,2);
//		kfar(t, 25, 2);
//		Node t2 = construct(arr2);
//		kfar(t2,9,3);
//		Kdown(t2, null, 2);
//		System.out.println("");
//		display(t);
//		removeleaves2(t);
		System.out.println("=========");
//		display(t);
//		psc(t);
		pir(t, t, 0, 200);

	}

}
