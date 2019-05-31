package graph1;

import java.util.*;

import graph1.g1.edge;

public class Dijkstra {
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

	static class Djhelper implements Comparable<Djhelper> {
		int vertex;
		String path;
		int dist;

		Djhelper(int vertex, String path, int dist) {
			this.vertex = vertex;
			this.path = path;
			this.dist = dist;
		}

		public int compareTo(Djhelper other) {
			return this.dist - other.dist;
		}
	}

	public static void Dijkstra1(ArrayList<ArrayList<edge>> graph, int src) {
		PriorityQueue<Djhelper> q = new PriorityQueue<>();
		boolean[] visit = new boolean[graph.size()];

		q.add(new Djhelper(src, src + "", 0));
		while (q.size() > 0) {
			Djhelper rem = q.peek();
			q.remove();
			if (visit[rem.vertex]) {
				continue;
			} else {
				visit[rem.vertex] = true;
			}

			System.out.println(rem.vertex + " " + "via" + rem.path + " @" + rem.dist);

			for (int i = 0; i < graph.get(rem.vertex).size(); i++) {
				if (!visit[graph.get(rem.vertex).get(i).v]) {
					edge ne = graph.get(rem.vertex).get(i);
					q.add(new Djhelper(ne.v, rem.path + " " + ne.v, rem.dist + ne.w));
				}
			}
		}
	}

	static class prhelper implements Comparable<prhelper> {
		int vertex;
		int via;
		int dist;

		prhelper(int vertex, int via, int dist) {
			this.vertex = vertex;
			this.via = via;
			this.dist = dist;
		}

		public int compareTo(prhelper other) {
			return this.dist - other.dist;
		}
	}

	public static ArrayList<ArrayList<edge>> prims1(ArrayList<ArrayList<edge>> graph) {
		PriorityQueue<prhelper> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[graph.size()];
		ArrayList<ArrayList<edge>> st = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			st.add(new ArrayList<>());
		}
		
		pq.add(new prhelper(0, -1, 0));

		while (pq.size() > 0) {
			prhelper rem = pq.peek();
			pq.remove();
			if (visit[rem.vertex]) {
				continue;
			} else {
				visit[rem.vertex] = true;
			}
			if (rem.via != -1)
				addEdge(st, rem.vertex, rem.via, rem.dist);
			
			for (int i = 0; i < graph.get(rem.vertex).size(); i++) {
				if (!visit[graph.get(rem.vertex).get(i).v]) {
					edge ne = graph.get(rem.vertex).get(i);
					pq.add(new prhelper(ne.v, rem.vertex, ne.w));
				}
			}
		}
		return st;
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
//		Dijkstra1(graph,0);
//		System.out.println();
		ArrayList<ArrayList<edge>> mst = prims1(graph);
		display(mst);
	}

}
