package graph;

import java.util.Stack;

public class TopologicalSort {
	
	private Stack<Vertex> stack;
	
	public TopologicalSort(){
		stack = new Stack<>();
	}

	public Stack<Vertex> getStack() {
		return stack;
	}
	
	public void dfs(Vertex vertex) {
		
		vertex.setVisited(true);
		
		for(Vertex v: vertex.getAdjacencyList()) {
			if(!v.isVisited()) {
				dfs(v);
			}
		}
		
		stack.push(vertex);
	}


}
