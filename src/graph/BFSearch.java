package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSearch {
	
	public static void main(String[] args) {
		
		Vertex graph = contructGraph();
		BFSearch bfs = new BFSearch();
		bfs.travers(graph);
	}

	public void travers(Vertex root) {
		Queue<Vertex> queue = new LinkedList<>();
		root.setVisited(true);
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Vertex actualVertex = queue.remove();
			System.out.println("actual vertex visited: "+actualVertex);
			for(Vertex v: actualVertex.getAdjacencyList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					queue.add(v);
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
