package graph.application;

import graph.util.SimpleAdjacencyListGraph;
import graph.util.SimpleWeightedAdjacencyListGraph;

public class ShortestPathTest {

	public static void main(String[] args) {

		//shortestPathUnwighted();
		sortestPathWeighted();
	}

	private static void sortestPathWeighted() {
		
		ShortestPathWeighted c = new ShortestPathWeighted();
		
		SimpleWeightedAdjacencyListGraph g = new SimpleWeightedAdjacencyListGraph(6, true)
				.addEdge(0, 1, 3)
				.addEdge(0, 2, 2)
				.addEdge(1, 3, 4)
				.addEdge(2, 4, 5)
				.addEdge(3, 5, 1)
				.addEdge(3, 4, 5)
				.addEdge(1, 4, 4)
				.addEdge(4, 5, 3);
		
		g.print();
		System.out.println("Shorted path for weighted graph with Dijktra algo");
		System.out.println("shortest dist->"+c.dijkstra(g.get(), 6, 0, 5));
		
	}

	private static void shortestPathUnwighted() {
		ShortestPathUnweighted c = new ShortestPathUnweighted();

		SimpleAdjacencyListGraph g = new SimpleAdjacencyListGraph(6).addEdge(0, 1).addEdge(0, 2).addEdge(1, 3)
				.addEdge(2, 3).addEdge(2, 5).addEdge(3, 4).addEdge(4, 5).addEdge(3, 5);

		g.print();
		System.out.println("Shorted path for unweighted graph");
		System.out.println(c.bfs(g.get(), 0, 5));
	}
}
