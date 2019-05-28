package graph1;

import java.util.ArrayList;
import java.util.LinkedList;

public class g1 {
	public static class edge {
		int v;
		int w;

		edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void addEdge(ArrayList<ArrayList<edge>> graph, int v1, int v2, int w) {
		graph.get(v1).add(new edge(v2, w));
		graph.get(v2).add(new edge(v1, w));
	}

	public static void display(ArrayList<ArrayList<edge>> graph) {

		for (int i = 0; i < graph.size(); i++) {
			System.out.println(i + " ->");
			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print(" | " + graph.get(i).get(j).v + " @ " + graph.get(i).get(j).w);
			}
			System.out.println();
		}
	}

	public static boolean hasPath(ArrayList<ArrayList<edge>> graph, int src, int dest, boolean[] visit) {
		if (src == dest) {
			return true;
		}
		visit[src] = true;
		ArrayList<edge> vsrc = graph.get(src);
		for (int i = 0; i < vsrc.size(); i++) {
			if (visit[vsrc.get(i).v] == false) {

				if (hasPath(graph, vsrc.get(i).v, dest, visit)) {
					return true;
				}
				// visit[vsrc.get(i).v] = false;
			}
		}
		return false;

	}

	// inclusive approach
	public static void printAllPath(ArrayList<ArrayList<edge>> graph, int src, int dest, String asf, boolean[] visit) {
		if (src == dest) {
			System.out.println(asf);
			return;
		}

		ArrayList<edge> vsrc = graph.get(src);
		for (int i = 0; i < vsrc.size(); i++) {
			if (visit[vsrc.get(i).v] == false) {
				visit[vsrc.get(i).v] = true;
				asf += vsrc.get(i).v + " ->";
				printAllPath(graph, vsrc.get(i).v, dest, asf, visit);
				visit[vsrc.get(i).v] = false;
			}
		}
	}

	private static class Helper {
		static int mn = Integer.MAX_VALUE;
//		static int mx = Integer.MIN_VALUE;
		static int ceil = Integer.MAX_VALUE;
		static int floor = Integer.MIN_VALUE;
		static String masf = "";
	}

	public static void smallestPath(ArrayList<ArrayList<edge>> graph, int src, int dest, int cost, String asf, Helper H,
			boolean[] visit, int cf) {
		if (src == dest) {
			if (cost < H.mn) {
				H.mn = cost;
				H.masf = asf;
			}
			H.ceil = cost < H.ceil && cost > cf ? cost : H.ceil;
			H.floor = cost > H.floor && cost < cf ? cost : H.floor;

			return;
		}

		ArrayList<edge> vsrc = graph.get(src);
		for (int i = 0; i < vsrc.size(); i++) {
			if (visit[vsrc.get(i).v] == false) {
				visit[vsrc.get(i).v] = true;
				cost = cost + vsrc.get(i).w;
				asf += vsrc.get(i).v + " ->";
				smallestPath(graph, vsrc.get(i).v, dest, cost, asf, H, visit, cf);
				visit[vsrc.get(i).v] = false;
			}
		}
	}

	public static class Thelper {
		int vertex;
		String psf;
		int dsf;

		Thelper(int vertex, String psf, int dsf) {
			this.vertex = vertex;
			this.psf = psf;
			this.dsf = dsf;
		}
	}

	public static boolean bfs(ArrayList<ArrayList<edge>> graph, int src, int dest) {
		LinkedList<Thelper> q = new LinkedList<>();
		boolean[] visit = new boolean[graph.size()];

		q.add(new Thelper(src, src + "", 0));
		while (q.size() > 0) {
			Thelper rem = q.getFirst();
			q.removeFirst();
			System.out.println(rem.vertex + " " + "via" + rem.psf + " @" + rem.dsf);
			if (visit[rem.vertex]) {
				continue;
			} else {
				visit[rem.vertex] = true;
			}
			if (rem.vertex == dest) {
				return true;
			}

			for (int i = 0; i < graph.get(rem.vertex).size(); i++) {
				if (!visit[graph.get(rem.vertex).get(i).v]) {
					edge ne = graph.get(rem.vertex).get(i);
					q.add(new Thelper(ne.v, rem.psf + " " + ne.v, rem.dsf + ne.w));
				}
			}
		}
		return false;
	}

	public static class Fhelper {
		int i;
		int j;
		int t;

		Fhelper(int i, int j, int t) {
			this.i = i;
			this.j = j;
			this.t = t;
		}
	}

	public static boolean isValid(int[][] city, int i, int j) {
		if (i < 0 || i >= city.length || j < 0 || j >= city[0].length) {
			return false;
		} else if (city[i][j] == -1 && city[i][j] == 0) {
			return false;
		} else if (city[i][j] == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void fire(int[][] city) {
		LinkedList<Fhelper> q = new LinkedList<>();
		for (int i = 0; i < city.length; i++) {
			for (int j = 0; j < city[i].length; j++) {
				if (city[i][j] == 0) {
					q.add(new Fhelper(i, j, 0));
				}
			}
		}
		while (q.size() > 0) {
			Fhelper rem = q.getFirst();
			q.removeFirst();
			if (city[rem.i][rem.j] > 0) {
				continue;
			} else {
				city[rem.i][rem.j] = rem.t;
			}
			System.out.println(rem.i + " " + rem.j + " @" + rem.t);

			if (isValid(city, rem.i + 1, rem.j)) {
				q.add(new Fhelper(rem.i + 1, rem.j, rem.t + 1));
			}
			if (isValid(city, rem.i, rem.j + 1)) {
				q.add(new Fhelper(rem.i, rem.j + 1, rem.t + 1));
			}
			if (isValid(city, rem.i - 1, rem.j)) {
				q.add(new Fhelper(rem.i - 1, rem.j, rem.t + 1));
			}
			if (isValid(city, rem.i, rem.j - 1)) {
				q.add(new Fhelper(rem.i, rem.j - 1, rem.t + 1));

			}
		}
	}

	public static class Ihelper {
		int i;
		int j;

		Ihelper(int i, int j) {
			this.i = i;
			this.j = j;

		}
	}

	public static boolean isIValid(int[][] city, int i, int j) {
		if (i < 0 || i >= city.length || j < 0 || j >= city[0].length) {
			return false;
		} else if (city[i][j] == -1) {
			return false;
		} else if (city[i][j] == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void getIslands(int[][] island) {
//		ArrayList<String> a = new ArrayList<>();
//		boolean[][] visit = new boolean[island.length][island.length];
		int count = 0;
		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island[i].length; j++) {
				if (island[i][j] == 0) {
					getIsland(island, i, j);
					count++;
				}
			}
		}
//		for (int i = 0; i < a.size(); i++) {
//			System.out.println(a.get(i));
//		}
		System.out.println(count);
	}

	public static void getIsland(int[][] island, int srci, int srcj) {
		LinkedList<Ihelper> q = new LinkedList<>();
		String ans = new String();
		q.add(new Ihelper(srci, srcj));
		while (q.size() > 0) {
			Ihelper rem = q.getFirst();
			q.removeFirst();
			if (island[rem.i][rem.j] > 0) {
				continue;
			} else {
				island[rem.i][rem.j] = 1;
			}
			if (isValid(island, rem.i + 1, rem.j)) {
				q.add(new Ihelper(rem.i + 1, rem.j));
			}
			if (isValid(island, rem.i, rem.j + 1)) {
				q.add(new Ihelper(rem.i, rem.j + 1));
			}
			if (isValid(island, rem.i - 1, rem.j)) {
				q.add(new Ihelper(rem.i - 1, rem.j));
			}
			if (isValid(island, rem.i, rem.j - 1)) {
				q.add(new Ihelper(rem.i, rem.j - 1));
			}
		}
//		return ans;

	}

	public static ArrayList<Integer> cc(ArrayList<ArrayList<edge>> graph, int src, boolean[] visit) {
		LinkedList<Integer> q = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		q.add(src);
		while (q.size() > 0) {
			int rem = q.getFirst();
			q.removeFirst();
//			System.out.println(rem.vertex + " " + "via" + rem.psf + " @" + rem.dsf);
			if (visit[rem]) {
				continue;
			} else {
				visit[rem] = true;
			}
			ans.add(rem);
			for (int i = 0; i < graph.get(rem).size(); i++) {
				if (!visit[graph.get(rem).get(i).v]) {
					edge ne = graph.get(rem).get(i);

					q.add(ne.v);
				}
			}
		}
		return ans;
	}

//	public static boolean isBipartite(ArrayList<ArrayList<edge>> graph) {
//	master function required do it in the future
//	}
	public static boolean isBipartite(ArrayList<ArrayList<edge>> graph) {
		LinkedList<Thelper> q = new LinkedList<>();
		int[] visit = new int[graph.size()];
		
		for(int i=0;i<visit.length;i++) {
			visit[i] = -1;
		}
		q.add(new Thelper(0, 0+ "", 0));
		while (q.size() > 0) {
			Thelper rem = q.getFirst();
			q.removeFirst();
//			System.out.println(rem.vertex + " " + "via" + rem.psf + " @" + rem.dsf);
			if (visit[rem.vertex] !=-1) {
				if(visit[rem.vertex] != rem.dsf%2) {
					return false;
				}
				continue;
			} else {
				visit[rem.vertex] = rem.dsf%2;
			}
			
			
			for (int i = 0; i < graph.get(rem.vertex).size(); i++) {
				if (visit[graph.get(rem.vertex).get(i).v] == -1) {
					edge ne = graph.get(rem.vertex).get(i);
					q.add(new Thelper(ne.v, rem.psf + " " + ne.v, rem.dsf +1));
				}
			}
		}
		return true;
	}
	public static void ccs(ArrayList<ArrayList<edge>> graph) {
		boolean[] visit = new boolean[graph.size()];
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();

		for (int i = 0; i < visit.length; i++) {

			if (!visit[i]) {
//				System.out.println("*");
				a.add(cc(graph, i, visit));
			}
		}
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}

	}

	public static boolean detectCyclic(ArrayList<ArrayList<edge>> graph) {
		LinkedList<Thelper> q = new LinkedList<>();
		boolean[] visit = new boolean[graph.size()];

		q.add(new Thelper(0, 0 + "", 0));
		while (q.size() > 0) {
			Thelper rem = q.getFirst();
			q.removeFirst();
//			System.out.println(rem.vertex + " " + "via" + rem.psf + " @" + rem.dsf);
			if (visit[rem.vertex]) {
				return true;
			} else {
				visit[rem.vertex] = true;
			}
			for (int i = 0; i < graph.get(rem.vertex).size(); i++) {
				if (!visit[graph.get(rem.vertex).get(i).v]) {
					edge ne = graph.get(rem.vertex).get(i);
					q.add(new Thelper(ne.v, rem.psf + " " + ne.v, rem.dsf + ne.w));
				}
			}
		}

		return false;
	}

	public static void astro(int[] a1, int[] a2, int n) {
		ArrayList<ArrayList<edge>> assGraph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			assGraph.add(new ArrayList<>());
		}
		for (int i = 0; i < a1.length; i++) {
			addEdge(assGraph, a1[i], a2[i], 0);
		}

		boolean[] visit = new boolean[assGraph.size()];
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();

		for (int i = 0; i < visit.length; i++) {

			if (!visit[i]) {
				a.add(cc(assGraph, i, visit));
			}
		}
		int count = 0;
//		for (int i = 0; i < a.size(); i++) {
//			if (a.get(i).length() <= 4) {
//				a.remove(i);
//			}
//		}
		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
//				System.out.println(a.get(i));
				count += a.get(i).size() * a.get(j).size();
			}
		}
		System.out.println(count);

	}

	public static void minFarthest(ArrayList<ArrayList<edge>> graph) {
		int[] far = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			far[i] = Farthest(graph, i);
		}
		int min = Integer.MAX_VALUE;
		int pos = -1;
		for (int i = 0; i < far.length; i++) {
//			System.out.print(far[i] + " ");
			if (far[i] < min) {
				min = far[i];
				pos = i;
			}
		}
//		System.out.println(pos);
		for (int i = 0; i < far.length; i++) {
			if (far[i] == min) {
				System.out.println(i);
			}
		}

	}

	public static int Farthest(ArrayList<ArrayList<edge>> graph, int src) {
		LinkedList<Thelper> q = new LinkedList<>();
		boolean[] visit = new boolean[graph.size()];
		int far = 0;
		q.add(new Thelper(src, src + "", 0));
		while (q.size() > 0) {
			Thelper rem = q.getFirst();
			q.removeFirst();
//			System.out.println(rem.vertex + " " + "via" + rem.psf + " @" + rem.dsf);
			if (visit[rem.vertex]) {
				continue;
			} else {
				visit[rem.vertex] = true;
			}
			// work

			// ac
			for (int i = 0; i < graph.get(rem.vertex).size(); i++) {
				if (!visit[graph.get(rem.vertex).get(i).v]) {
					edge ne = graph.get(rem.vertex).get(i);
					q.add(new Thelper(ne.v, rem.psf + " " + ne.v, rem.dsf + ne.w));
					far = rem.dsf + ne.w;
				}
			}

		}
		return far;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 0, 1, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 5, 6, 3);
		
		// bipartite test case
//		addEdge(graph, 0, 1, 1);
//		addEdge(graph, 0, 3, 1);
//		addEdge(graph, 1, 2, 1);
//		addEdge(graph, 2, 3, 1);
//		addEdge(graph, 2, 5, 1);
//		addEdge(graph, 3, 4, 1);
//		addEdge(graph, 4, 5, 1);
////		display(graph);
//		boolean[] visit = new boolean[7];
////		 System.out.println(hasPath(graph, 0, 6, visit));
//		visit[0] = true;
//		String asf = "0 ->";
////		printAllPath(graph, 0, 6, asf, visit);
//		Helper hp = new Helper();
//		smallestPath(graph, 0, 6, 0, asf, hp, visit, 40);
////		System.out.println(hp.masf + " ||" + hp.mn);
////		System.out.println(hp.ceil + " " + hp.floor);
////		System.out.println(bfs(graph, 0, 6));
//		int[][] city = { { -2, -2, 0, -2, -2, -2 }, { -2, -1, -1, -2, -1, -1 }, { -2, -2, -1, -2, -2, -2 },
//				{ -2, -2, -2, -2, -1, -1 }, { -2, -1, -1, 0, -2, -2 } };
////		fire(city);
////		ccs(graph);
//		int[][] island = { { 0, 0, -1, 0, 0 }, { 0, -1, -1, -1, -1, -1 }, { -1, 0, 0, 0, 0 }, { 0, -1, 0, -1, 0 },
//				{ 0, -1, -1, -1, 0 } };
////		getIslands(island);
//		System.out.println(detectCyclic(graph));
//		int[] a1 = { 1, 6, 8, 2, 9, 10, 0 };
//		int[] a2 = { 2, 9, 3, 5, 5, 3, 11 };
//		astro(a1, a2, 12);
//		
//		diameter question example
//		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
//		for (int i = 0; i < 23; i++) {
//			graph.add(new ArrayList<>());
//		}
//		addEdge(graph, 0, 1, 1);
//		addEdge(graph, 1, 22, 1);
//		addEdge(graph, 1, 2, 1);
//		addEdge(graph, 2, 3, 1);
//		addEdge(graph, 2, 7, 1);
//		addEdge(graph, 2, 5, 1);
//		addEdge(graph, 7, 8, 1);
//		addEdge(graph, 7, 9, 1);
//		addEdge(graph, 5, 4, 1);
//		addEdge(graph, 5, 6, 1);
//		addEdge(graph, 4, 16, 1);
//		addEdge(graph, 16, 17, 1);
//		addEdge(graph, 15, 16, 1);
//		addEdge(graph, 16, 18, 1);
//		addEdge(graph, 18, 19, 1);
//		addEdge(graph, 19, 20, 1);
//		addEdge(graph, 19, 21, 1);
//		addEdge(graph, 6, 10, 1);
//		addEdge(graph, 10, 11, 1);
//		addEdge(graph, 10, 12, 1);
//		addEdge(graph, 12, 13, 1);
//		addEdge(graph, 12, 14, 1);
//		minFarthest(graph);
		System.out.println(isBipartite(graph));
	}

}
