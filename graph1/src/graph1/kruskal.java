package graph1;

import java.util.*;

import graph1.Dijkstra.edge;

public class kruskal {

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

	static class kEdge implements Comparable<kEdge> {
		int v1;
		int v2;
		int w;

		kEdge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		public int compareTo(kEdge other) {
			return this.w - other.w;

		}
	}

	public static int find(int[] pa, int v) {
		if (pa[v] == v) {
			return v;
		} else {
			return find(pa, pa[v]);

		}
	}

	public static void merge(int[] pa, int[] ra, int v1sl, int v2sl) {
		if (ra[v1sl] > ra[v2sl]) {
			pa[v2sl] = v1sl;
		} else if (ra[v1sl] < ra[v2sl]) {
			pa[v1sl] = v2sl;
		} else if (ra[v1sl] == ra[v2sl]) {
			ra[v1sl]++;
			pa[v2sl] = v1sl;
		}
	}

	public static ArrayList<ArrayList<edge>> kruskal1(ArrayList<ArrayList<edge>> graph) {
		ArrayList<ArrayList<edge>> mst = new ArrayList<ArrayList<edge>>();
		PriorityQueue<kEdge> pq = new PriorityQueue<>();
//		boolean[] visit = new boolean[graph.size()];
		int[] pa = new int[graph.size()];
		int[] ra = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			pa[i] = i;
			ra[i] = 1;
			mst.add(new ArrayList<edge>());
		}
		int ctr = 0;
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				edge ne = graph.get(i).get(j);
				if (i < ne.v) { // check
					pq.add(new kEdge(i, ne.v, ne.w));
				}
			}
		}

		while (pq.size() > 0 && ctr < graph.size()) {
			kEdge rem = pq.remove();
			int v1sl = find(pa, rem.v1);
			int v2sl = find(pa, rem.v2);
			if (v1sl != v2sl) {
				ctr++;
				addEdge(mst, rem.v1, rem.v2, rem.w);
				merge(pa, ra, v1sl, v2sl);
			}
		}

		return mst;
	}

	public static void hamiltonianhelper(ArrayList<ArrayList<edge>> graph, int src) {
		for (int i = 0; i < graph.size(); i++) {
//			System.out.println(i + " ->");
			for (int j = 0; j < graph.get(i).size(); j++) {
//				hamiltonian()
			}
		}
	}

	public static void hamiltonian(ArrayList<ArrayList<edge>> graph, int src, ArrayList<Integer> ans, boolean[] visit) {
		if (ans.size() == graph.size() - 1) {
			for (int i = 0; i < graph.get(src).size(); i++) {
				if (graph.get(src).get(i).v == ans.get(0)) {
					ans.add(-1);
					System.out.println(ans);

				} else {
					ans.add(-2);
					System.out.println(ans);
				}
			}
			return;
		}

		ArrayList<edge> vsrc = graph.get(src);
		for (int i = 0; i < vsrc.size(); i++) {
			if (visit[vsrc.get(i).v] == false) {
				visit[vsrc.get(i).v] = true;
				ans.add(vsrc.get(i).v);
				hamiltonian(graph, vsrc.get(i).v, ans, visit);
				visit[vsrc.get(i).v] = false;
			}
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
		ArrayList<ArrayList<edge>> mst = kruskal1(graph);
		display(mst);
	}

}
