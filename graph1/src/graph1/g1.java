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
		} else if (city[i][j] == -2) {
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
		int vertex;
		int ino;

		Ihelper(int vertex, int ino) {
			this.vertex = vertex;
			this.ino = ino;

		}
	}

	public static void getIslands(int[][] island) {
//		LinkedList<Ihelper> q = new LinkedList<>();
		ArrayList<String> a = new ArrayList<>();
		boolean[][] visit = new boolean[island.length][island.length];
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit[i].length; j++) {
				if (!visit[i][j]) {
//				System.out.println("*");
					a.add(getIsland(island, i, visit));
				}
			}
		}
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

	public static String getIsland(int[][] island, int src, boolean[] visit) {
		LinkedList<Integer> q = new LinkedList<>();
		String ans = new String();
		q.add(src);
		while (q.size() > 0) {
			int rem = q.getFirst();
			q.removeFirst();
			if (visit[rem]) {
				continue;
			} else {
				visit[rem] = true;
			}
			ans += rem + " ";
			for (int i = 0; i < graph.get(rem).size(); i++) {
				if (!visit[graph.get(rem).get(i).v]) {
					edge ne = graph.get(rem).get(i);

					q.add(ne.v);
				}
			}
		}
		return ans;

	}

	public static String cc(ArrayList<ArrayList<edge>> graph, int src, boolean[] visit) {
		LinkedList<Integer> q = new LinkedList<>();
		String ans = new String();
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
			ans += rem + " ";
			for (int i = 0; i < graph.get(rem).size(); i++) {
				if (!visit[graph.get(rem).get(i).v]) {
					edge ne = graph.get(rem).get(i);

					q.add(ne.v);
				}
			}
		}
		return ans;
	}

	public static void ccs(ArrayList<ArrayList<edge>> graph) {
		boolean[] visit = new boolean[graph.size()];
		ArrayList<String> a = new ArrayList<>();

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
//		display(graph);
		boolean[] visit = new boolean[7];
//		 System.out.println(hasPath(graph, 0, 6, visit));
		visit[0] = true;
		String asf = "0 ->";
//		printAllPath(graph, 0, 6, asf, visit);
		Helper hp = new Helper();
		smallestPath(graph, 0, 6, 0, asf, hp, visit, 40);
//		System.out.println(hp.masf + " ||" + hp.mn);
//		System.out.println(hp.ceil + " " + hp.floor);
//		System.out.println(bfs(graph, 0, 6));
		int[][] city = { { -2, -2, 0, -2, -2, -2 }, { -2, -1, -1, -2, -1, -1 }, { -2, -2, -1, -2, -2, -2 },
				{ -2, -2, -2, -2, -1, -1 }, { -2, -1, -1, 0, -2, -2 } };
//		fire(city);
//		ccs(graph);
		int[][] island = { { 0, 0, -1, 0, 0 }, { 0, -1, -1, -1, -1, -1 }, { -1, 0, 0, 0, 0 }, { 0, -1, 0, -1, 0 },
				{ 0, -1, -1, -1, 0 } };

	}

}
