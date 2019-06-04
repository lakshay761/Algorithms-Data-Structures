package graph1;

import java.util.ArrayList;
import java.util.Stack;

import graph1.g1.edge;

public class topologicalSort {
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
//		graph.get(v2).add(new edge(v1, w));
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

	public static void tsSlave(ArrayList<ArrayList<edge>> graph, int src, boolean[] visit, Stack<Integer> st) {
		visit[src] = true;
		ArrayList<edge> vsrc = graph.get(src);
		for (int i = 0; i < vsrc.size(); i++) {
			if (visit[vsrc.get(i).v] == false) {
				tsSlave(graph, vsrc.get(i).v, visit, st);
			}
		}
		st.push(src);

	}

	public static void tsMaster(ArrayList<ArrayList<edge>> graph) {
		boolean[] visit = new boolean[graph.size()];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i]) {
				tsSlave(graph, i, visit, st);
			}
		}
		for (int i = 0; i < visit.length; i++) {
			System.out.print(st.pop() + " ");
		}
//		System.out.println(st);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 0, 4, 1);
		addEdge(graph, 0, 1, 1);
		addEdge(graph, 1, 2, 1);
		addEdge(graph, 2, 3, 1);
		addEdge(graph, 5, 4, 1);
		addEdge(graph, 5, 6, 1);
		addEdge(graph, 6, 3, 1);
		
		
		display(graph);
		tsMaster(graph);
		
	}

}
