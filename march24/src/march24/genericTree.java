package march24;

import java.util.*;

public class genericTree {

	private static class Node {
		private int data;
		private ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	private static Node construct(ArrayList<Integer> dList) {
		Node root = null;
		ArrayList<Node> nList = new ArrayList<>();
		for (int i = 0; i < dList.size(); i++) {
			Node nn = new Node(dList.get(i));
			if (dList.get(i) == -1) {
				nList.remove(nList.size() - 1);
			} else {
				if (nList.size() == 0) {
					root = nn;
				} else {
					Node ln = nList.get(nList.size() - 1);
					ln.children.add(nn);
				}
				nList.add(nn);
			}
		}
		return root;
	}

	public static void display(Node n1) {
		String s1 = n1.data + "->";
		for (int i = 0; i < n1.children.size(); i++) {
			s1 += n1.children.get(i).data + ",";
		}
		System.out.println(s1 + ".");
		for (int i = 0; i < n1.children.size(); i++) {
			display(n1.children.get(i));
		}
	}

	public static int size(Node root) {
		int fsize = 1;
		for (int i = 0; i < root.children.size(); i++) {
			fsize += size(root.children.get(i));
		}
		return fsize;
	}

	public static int max(Node root) {
		int max = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			int lmax = max(root.children.get(i));
			if (lmax > max) {
				max = lmax;
			}
		}
		return max;
	}

	public static boolean find(Node root, int dtf) {
		if (root.data == dtf) {
			return true;
		}
		for (int i = 0; i < root.children.size(); i++) {
			if (find(root.children.get(i), dtf)) {
				return true;
			}
		}
		return false;
	}

	public static int height(Node root) {
		int rh = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int ch = height(root.children.get(i));
			if (ch > rh) {
				rh = ch;
			}
		}
		rh += 1;
		return rh;
	}

	public static ArrayList<Integer> NodeToRoot(Node root, int dtf) {
		if (root.data == dtf) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(root.data);
			return path;
		}

		for (int i = 0; i < root.children.size(); i++) {
			{
				ArrayList<Integer> ntc = NodeToRoot(root.children.get(i), dtf);
				if (ntc != null) {
					ntc.add(root.data);
					return ntc;
				}
			}
		}
		return null;
	}

	public static int lca(Node root, int d1, int d2) {
		ArrayList<Integer> l1 = NodeToRoot(root, d1);
		ArrayList<Integer> l2 = NodeToRoot(root, d2);
		int i = 0;
		int j = 0;
		for (i = l1.size() - 1, j = l2.size() - 1; i >= 0 && j >= 0; j--, i--) {
			if (l1.get(i) != l2.get(j)) {
				return l1.get(i + 1);
			}
		}
		return l1.get(i + 1);
	}

	public static int distance(Node root, int d1, int d2) {
		ArrayList<Integer> l1 = NodeToRoot(root, d1);
		ArrayList<Integer> l2 = NodeToRoot(root, d2);
		int i = 0;
		int j = 0;
		for (i = l1.size() - 1, j = l2.size() - 1; i >= 0 && j >= 0; j--, i--) {
			if (l1.get(i) != l2.get(j)) {
				break;
			}
		}
		return i + 1 + j + 1 + 1;
	}

	public static void mirror(Node root) {

		for (int i = 0, j = root.children.size() - 1; i < j; i++, j--) {
			Node left = root.children.get(i);
			Node right = root.children.get(j);
			root.children.set(i, right);
			root.children.set(j, left);
		}
		for (int i = 0; i < root.children.size(); i++) {
			mirror(root.children.get(i));
		}
	}

	public static Node linearize2(Node root) {
		if (root.children.size() == 0) {
			return root;
		}
		Node ol = root.children.get(root.children.size() - 1);
		Node olt = linearize2(ol);

		while (root.children.size() > 1) {
			Node s1 = root.children.get(root.children.size() - 2);
			Node slt = linearize2(s1);

			Node last = root.children.get(root.children.size() - 1);
			root.children.remove(root.children.size() - 1);
			slt.children.add(last);

		}
		return olt;
	}

	// public static void removeLeaves()
	public static boolean ass(Node root1, Node root2) {
		if (root1.children.size() == root2.children.size()) {
			for (int i = 0; i < root1.children.size(); i++) {

				if (ass(root1.children.get(i), root2.children.get(i)) == false) {
					return false;
				}

			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean ams(Node root1, Node root2) {
		if (root1.children.size() == root2.children.size()) {
			for (int i = 0, j = root2.children.size() - 1; i < root1.children.size() && j >= 0; i++, j--) {

				if (ams(root1.children.get(i), root2.children.get(j)) == false) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSymmetric(Node root) {
		return ams(root, root);
	}

	private static class Heapmover {
		static int sum = 0;
		static int wn = 0;
		static int sz = 0;
		static int ht = 0;
		static int mn = Integer.MAX_VALUE;
		static int mx = Integer.MIN_VALUE;
		static int ceil = Integer.MAX_VALUE;
		static int floor = Integer.MIN_VALUE;
		static int pre = 0;
		static int post = 0;
		static int previous = 0;

		public static void display() {
			System.out.println("size is " + sz);
			System.out.println("min is" + mn);
			System.out.println("max is" + mx);
			System.out.println("ceil is" + ceil);
			System.out.println("floor is" + floor);
			System.out.println("pre is " + pre);
			System.out.println("post is " + post);

		}

	}

	public static void floor(Node root, Heapmover H, int no) {
		H.floor = root.data > H.floor && root.data < no ? root.data : H.floor;
		for (int i = 0; i < root.children.size(); i++) {
			floor(root.children.get(i), H, no);
		}

	}

	public static void multisolver(Node root, int depth, Heapmover H, int no) {
		H.sz++;
		H.ht = depth > H.ht ? depth : H.ht;
		H.mn = root.data < H.mn ? root.data : H.mn;
		H.mx = root.data > H.mx ? root.data : H.mx;
		H.ceil = root.data < H.ceil && root.data > no ? root.data : H.ceil;
		H.floor = root.data > H.floor && root.data < no ? root.data : H.floor;
		if (root.data == no) {
			H.pre = H.previous;
		}
		if (H.previous == no) {
			H.post = root.data;
		}
		H.previous = root.data;

		for (int i = 0; i < root.children.size(); i++) {
			multisolver(root.children.get(i), depth + 1, H, no);
		}
	}

	public static int kthLargest(Node root, Heapmover H, int k) {
		int m = Integer.MAX_VALUE;
		for (int j = 0; j < k; j++) {
			floor(root, H, m);
			m = H.floor;
			H.floor = Integer.MIN_VALUE;
		}
		return m;
	}

	public static void sum(Node root, Heapmover H) {
		H.sum += root.data;
		for (int i = 0; i < root.children.size(); i++) {
			sum(root.children.get(i), H);
		}
	}

	public static void CWnodes(Node root, Heapmover H) {
		// if(H.sum = )
		for (int i = 0; i < root.children.size(); i++) {
			CWnodes(root.children.get(i), H);
		}
	}

	public static void levelOrder(Node root) {
		LinkedList<Node> list = new LinkedList();
		list.add(root);

		while (list.size() != 0) {
			Node first = list.getFirst();
			list.removeFirst();
			System.out.println(first.data);
			for (int i = 0; i < first.children.size(); i++) {
				list.add(first.children.get(i));
			}
		}
	}

	public static void lolw(Node root) {
		LinkedList<Node> list = new LinkedList();
		list.add(root);
		list.add(null);
		while (list.size() != 0) {
			Node first = list.getFirst();
			Node rn = list.removeFirst();
			if (rn == null) {
				System.out.println();
				if (list.size() != 0)
					list.add(null);
			} else {
				System.out.print(rn.data + " ");
				for (int i = 0; i < first.children.size(); i++) {
					list.add(first.children.get(i));
				}
			}
		}
	}

	public static void lolwcurr(Node root) {
		LinkedList<Node> curr = new LinkedList();
		LinkedList<Node> next = new LinkedList();
		curr.add(root);
		while (curr.size() != 0) {
			Node first = curr.getFirst();
			Node rn = curr.removeFirst();
			System.out.print(rn.data + " ");

			for (int i = 0; i < first.children.size(); i++) {
				next.addLast(first.children.get(i));
			}
			if (curr.size() == 0) {
				curr = next;
				next = new LinkedList<Node>();
				System.out.println();
			}
		}
	}

	public static void lolzzcurr(Node root) {
		LinkedList<Node> curr = new LinkedList();
		LinkedList<Node> next = new LinkedList();
		curr.add(root);
		int flag = 0;
		while (curr.size() != 0) {
			Node first = curr.getFirst();
			Node rn = curr.removeFirst();
			System.out.print(rn.data + " ");

			if (flag == 0) {
				for (int i = 0; i < first.children.size(); i++) {
					next.addFirst(first.children.get(i));
				}
			} else {
				for (int i = first.children.size() - 1; i >= 0; i--) {
					next.addFirst(first.children.get(i));
				}
			}

			if (curr.size() == 0) {
				curr = next;
				next = new LinkedList<Node>();
				flag = flag == 0 ? 1 : 0;
				System.out.println();
			}
		}
	}

//	public static void lozz(Node root) {
//		LinkedList<Node> list = new LinkedList();
//		list.add(root);
//		int flag = 0;
//		while (list.size() != 0) {
//			Node first = list.getLast();
//			Node rn = list.removeLast();
//			System.out.print(rn.data + " ");
//			if (flag == 0) {
//				for (int i = 0; i < first.children.size(); i++) {
//					list.add(first.children.get(i));
//				}
//				flag = 1;
//			} else {
//				for (int i = first.children.size() - 1; i >= 0; i--) {
//					list.addFirst(first.children.get(i));
//				}
//				// flag =0;
//			}
//		}
//
//	}
//
	public static class Ehelper {
		Node root;
		int state = 0;

		public Ehelper(Node r, int s) {
			root = r;
			state = s;
		}
	}

	public static void eularIter(Node root) {
		LinkedList<Ehelper> stack = new LinkedList<>();
		Ehelper rh = new Ehelper(root, 0);
		stack.addFirst(rh);
		while (stack.size() != 0) {
			Ehelper th = stack.getFirst();
			if (th.state == 0) {
				System.out.println("pre " + th.root.data);
				th.state++;
			} else if (th.state >= 1 && th.state <= th.root.children.size()) {
				Ehelper ch = new Ehelper(th.root.children.get(th.state - 1), 0);
				stack.addFirst(ch);
				if (th.state >= 2) {
					System.out.println("in" +(th.state - 1) + " "+ th.root.data);
				}
				th.state++;
			} else if (th.state == th.root.children.size() + 1) {
				System.out.println("post " + th.root.data);
				th.state++;
			} else if (th.state == th.root.children.size() + 2) {
				stack.removeFirst();
				th.state++;
			}
		}
	}

	public static class khelper{
		String ques;
		String ans;
		Node root;
		int state;
	//	public khelper(Node r,)
	}
	public static void kpc(String s) {
		String[] codes = { "-", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wx", "yz" };
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> dList = new ArrayList<>();
		dList.add(10);
		dList.add(20);
		dList.add(50);
		dList.add(-1);
		dList.add(60);
		dList.add(-1);
		dList.add(-1);
		dList.add(30);
		dList.add(70);
		dList.add(-1);
		dList.add(80);
		dList.add(110);
		dList.add(-1);
		dList.add(120);
		dList.add(-1);
		dList.add(-1);
		dList.add(90);
		dList.add(-1);
		dList.add(-1);
		dList.add(40);
		dList.add(100);
		dList.add(-1);
		dList.add(-1);
		dList.add(-1);
		Node t = construct(dList);
		display(t);
		System.out.println(size(t));
		System.out.println(max(t));
		System.out.println(find(t, 55));
		System.out.println(find(t, 30));
		System.out.println(height(t));
		System.out.println(NodeToRoot(t, 120));
		System.out.println(lca(t, 120, 70));
		System.out.println(distance(t, 120, 70));
		System.out.println("treee");
		display(t);
//		mirror(t);
//		System.out.println("mirrored");
//		display(t);
//		System.out.println("linearize");
//		linearize2(t);
//		display(t);
//		dList.remove(3);
		Node nt = construct(dList);
		display(nt);
		System.out.println(ass(t, nt));
		System.out.println(ams(t, nt));
		System.out.println(isSymmetric(t));
		Heapmover H = new Heapmover();
//		multisolver(t, 0, H, 60);
//		H.display();
//		System.out.println(kthLargest(t,H,3));
		levelOrder(t);
		lolw(t);
		lolwcurr(t);
		lolzzcurr(t);
		eularIter(t);
	}

}
