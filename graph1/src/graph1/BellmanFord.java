package graph1;

import java.util.ArrayList;

import graph1.Dijkstra.edge;
import graph1.kruskal.kEdge;

public class BellmanFord {

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
	public static void bellmanFord1(ArrayList<ArrayList<edge>> graph, int src) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
