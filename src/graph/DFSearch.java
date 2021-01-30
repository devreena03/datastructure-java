package graph;

import java.util.Stack;

public class DFSearch {
	
	public static void main(String[] args) {
		
		Vertex graph = contructGraph();
		DFSearch bfs = new DFSearch();
		//bfs.traversIterative(graph);
		bfs.traversRec(graph);
		
	}
	
	private void traversRec(Vertex vertex) {
		vertex.setVisited(true);
		System.out.println("actual vertex visited: "+vertex);
		for(Vertex v: vertex.getAdjacencyList()) {
			if(!v.isVisited()) {
				v.setVisited(true);
				traversRec(v);
			}
			
		}
	}

	public void traversIterative(Vertex root) {
		Stack<Vertex> stack = new Stack<>();
		root.setVisited(true);
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Vertex actualVertex = stack.pop();
			System.out.println("actual vertex visited: "+actualVertex);
			for(Vertex v: actualVertex.getAdjacencyList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					stack.push(v);
				}
				
			}
		}
	}
	
	private static Vertex contructGraph() {
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");	
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");

		a.addNeighbor(b);
		a.addNeighbor(f);
		a.addNeighbor(g);
		b.addNeighbor(c);
		b.addNeighbor(d);
		d.addNeighbor(e);
		g.addNeighbor(h);
		
		return a;
		
	}


}
