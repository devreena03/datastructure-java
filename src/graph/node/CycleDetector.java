package graph.node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CycleDetector {
	
	Set<Integer> isVisited;
	Set<Integer> isBeingVisited;
	
	boolean[] visited;
	
	public boolean directedGraph(Node node) {
		isVisited = new HashSet<>();
		isBeingVisited = new HashSet<>();
		
		return dfs(node);
		
	}
	
	private boolean dfs(Node node) {
		
		if(isBeingVisited.contains(node.val)) return true;
		
		 isBeingVisited.add(node.val);
		 
		 for(Node n: node.neighbors) {
			 if(!isVisited.contains(n.val)) {
				 if(dfs(n)) {
					return true;
				 } 	
			 }		
		  }
		 
		 isVisited.add(node.val);
		 isBeingVisited.remove(node.val);
		 
		return false;
	}
	
	public boolean undirectedGraph(ArrayList<Integer>[] graph) {
		visited = new boolean[graph.length];
		
		 for(int i=0; i<graph.length; i++) {
			 if(!visited[i]) {
				 if(dfsundirected(graph, i, -1)) 
					 return true;
			 }
		 }
		return false;
	}
	
	//returns false if no cycle.
	private boolean dfsundirected(ArrayList<Integer>[] graph, int v, int parent) {
		
		visited[v] = true;
		 
		 for(int i: graph[v]) {
			 if(!visited[i]) {
				 if(dfsundirected(graph, i, v)) {
					return true;
				 } 	
			 }	
			 else if(i!=parent) return true;
		  }
		 
		return false; 
	}

}
