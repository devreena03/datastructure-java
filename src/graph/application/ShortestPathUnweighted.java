package graph.application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweighted {
	
	int[] parent;
	
	public int bfs(ArrayList<Integer>[] graph, int source, int des) {
		
		parent = new int[graph.length];
		for(int i=0; i<parent.length; i++) {
			parent[i] = -2;
		}		
		parent[source] = -1;
		
		//BFS
		findParent(graph, source);
		
		return findPath(des);
	}

	private int findPath(int des) {
		for(int i=0; i<parent.length; i++) {
			System.out.print(parent[i]+", ");
		}
		System.out.println();
		
		int path=0;
		for(int i=des; i>=0; i = parent[i]) {
			
			if(parent[i]==-1) return path;
			
			path++;
		}
		
		return -1; //not found
	}

	private void findParent(ArrayList<Integer>[] graph, int source) {
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: graph[u]) {
				//v is not visited
				if(parent[v]==-2) {
					parent[v] = u;
					q.add(v);
				}				
			}
		}
	}

}
