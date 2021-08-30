package graph.node;

import graph.util.SimpleAdjacencyListGraph;

public class CycleDetectorTest {
	public static void main(String[] args) {
		NodeGraph node = new NodeGraph(true)
				.addEdge(1, 2)
				.addEdge(2, 3)
				.addEdge(3, 4)
				.addEdge(1, 4)
				.addEdge(3, 5)
				.addEdge(6, 3)
				.addEdge(5, 6);
		
		
		//node.print();
		
		CycleDetector c = new CycleDetector();
		//System.out.println(c.directedGraph(node.head()));
		
		SimpleAdjacencyListGraph g = new SimpleAdjacencyListGraph(6)
				.addEdge(0, 1)
				.addEdge(1, 2)
				.addEdge(2, 3)
				.addEdge(3, 4)
				.addEdge(3, 5);
		
		g.print();
		System.out.println(c.undirectedGraph(g.get()));
		
	}
}
