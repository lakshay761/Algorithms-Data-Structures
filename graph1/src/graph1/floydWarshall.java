package graph1;

import java.util.ArrayList;

import graph1.Dijkstra.edge;

//import graph1.g1.edge;

public class floydWarshall {
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
//			for directed 			
//			graph.get(v2).add(new edge(v1, w));
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

//	static class node{
//		int dist;
//		String path;
//		node(int dist,String path){
//			this.dist = dist;
//			this.path = path;
//		}
//	}
	public static void floyd(ArrayList<ArrayList<edge>> graph) {
		int[][] mat = new int[graph.size()][graph.size()];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = Integer.MAX_VALUE;
				if (i == j) {
					mat[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				edge ne = graph.get(i).get(j);
				mat[i][ne.v] = ne.w;
			}
		}

		for (int i = 0; i < graph.size(); i++) {
			for (int s = 0; s < graph.size(); s++) {
				for (int d = 0; d < graph.size(); d++) {

					if (s==d || s == i || d == i || mat[s][i] == Integer.MAX_VALUE || mat[i][d] == Integer.MAX_VALUE) {
						continue;
					} else if (mat[s][d] > mat[s][i] + mat[i][d]) {
						mat[s][d] = mat[s][i] + mat[i][d];
					}
				}
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if(mat[i][j] == Integer.MAX_VALUE) {
					System.out.print("NA	");	
				}else {
					System.out.print(mat[i][j] + "	");

				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 0, 1, 2);
		addEdge(graph, 0, 3, 8);
		addEdge(graph, 0, 2, 4);
		addEdge(graph, 1, 2, 1);
		addEdge(graph, 1, 3, 5);
		addEdge(graph, 2, 3, 1);
		floyd(graph);
	}

}
