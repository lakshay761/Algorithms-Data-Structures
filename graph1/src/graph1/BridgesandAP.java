package graph1;

import java.util.ArrayList;

import graph1.Dijkstra.edge;
//import graph1.g1;

public class BridgesandAP {
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
	static int timer = 0;
	public static void bridgesAndAp(ArrayList<ArrayList<edge>> graph,boolean[] visit,boolean[] aps,int[] disc,int[] low,int par,int src) {
		
		visit[src] = true;
		disc[src] = low[src] = timer ++;
		
		
		for(int i=0;i<graph.get(src).size();i++) {
			edge ne = graph.get(src).get(i);
			int nbr = ne.v;
			int counter = 0;
			if(visit[nbr] && par == nbr) {
				
			}
			else if(visit[nbr] && par != nbr){
				//back edge
				low[src] = Math.min(low[nbr],disc[src]);
			}
			else {
				counter++;
				bridgesAndAp(graph, visit, aps, disc, low, src, nbr);
				low[src] = Math.min(low[src], low[nbr]);
				if(disc[src] == 1) {	//root
					if(counter >=2) {
						aps[src] = true;
					}
				}
				else {	//not root
					if(low[nbr] >= disc[src]) {
						aps[src] = true;
						System.out.println(src);
					}
					if(low[nbr] > disc[src]) {
						System.out.println("bridge is " + src + " " + nbr);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
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
		addEdge(graph, 7, 0, 3);
		addEdge(graph, 7, 8, 3);
		addEdge(graph, 8, 0, 3);
		
		int[] low = new int[graph.size()];
		int[] disc = new int[graph.size()];
		boolean[] visit = new boolean[graph.size()];
		boolean[] aps = new boolean[graph.size()];
		
		bridgesAndAp(graph, visit, aps, disc, low, -1, 0);
		
	}

}
