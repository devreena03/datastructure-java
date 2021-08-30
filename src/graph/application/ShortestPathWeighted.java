package graph.application;

import java.util.ArrayList;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class ShortestPathWeighted {
	
	//Dijkstra algo
	public int dijkstra(ArrayList<Pair<Integer, Integer>>[] graph, int noOfVertex, int source, int dest) {
		
		int[] minWeight = new int[noOfVertex];
		boolean[] visited = new boolean[noOfVertex];
		for(int i=0; i<noOfVertex; i++) {
			minWeight[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		minWeight[source] = 0;
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((u,v)->Integer.compare(minWeight[u], minWeight[v]));
		queue.add(source);
		
			while(!queue.isEmpty()) {
				int v = queue.poll();
				if(!visited[v]) {
					visited[v] = true;
					for (Pair<Integer, Integer> pair: graph[v]) {
						int node = pair.getKey();
						minWeight[node] = Math.min(minWeight[node], minWeight[v]+pair.getValue());
						queue.add(node);
					}
					
				}
			}
			
			for(int i=0; i<noOfVertex; i++) {
				System.out.println(minWeight[i]+", ");
			}
		
		return minWeight[dest];
	}

}
