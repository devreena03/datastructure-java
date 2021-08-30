package graph.util;

public class GraphTest {
	
	public static void main(String[] args) {
		
		//matrixRepresentation();
		//adjacencyListRepresentation();
		
		genericGraphTest();
		
//		Graph g = new SimpleWeightedAdjacencyListGraph(6, true)
//				.addEdge(0, 1, 3)
//				.addEdge(0, 2, 2)
//				.addEdge(1, 3, 4)
//				.addEdge(2, 4, 5)
//				.addEdge(3, 5, 1)
//				.addEdge(3, 4, 5)
//				.addEdge(1, 4, 4)
//				.addEdge(4, 5, 3);
//		
//		g.print();
//		g.printBfs();
//		g.printDfs();
	}

	private static void genericGraphTest() {
//		GenericAdjacencyListGraph<Integer> g = new GenericAdjacencyListGraph<>();
//		g.addEdgeT(7, 4).addEdgeT(3, 5).addEdgeT(7, 3).addEdgeT(7, 5);
//		g.print();
//		g.removeEdge(7, 5);
//		g.print();
//		g.removeVertex(4);
//		g.print();
		
		Emp e1 = new Emp(1,"sam");
		Emp e2 = new Emp(2,"dekj");
		Emp e3 = new Emp(3,"john");
		Emp e4 = new Emp(4,"sam");
		GenericAdjacencyListGraph<Emp> g = new GenericAdjacencyListGraph<>();
		g.addEdgeT(e1, e2).addEdgeT(e2, e3).addEdgeT(e3, e4).addEdgeT(e4, e2);
		g.print();
		g.printBfs();
		g.printDfs();
	}

	private static void matrixRepresentation() {
		Graph g = new SimpleMatrixGraph(4).addEdge(0, 1).addEdge(1, 2).addEdge(2, 3).addEdge(3, 1);
		g.print();
		
		g.reset();
		g = new SimpleMatrixGraph(4, true).addEdge(0, 1).addEdge(0,3).addEdge(1, 2).addEdge(3, 2).addEdge(3, 1);
		g.print();
		
		g.reset();
		g = new SimpleWeightedMatrixGraph(4).addEdge(0, 1, 3).addEdge(1, 2, 5).addEdge(2, 3, 4).addEdge(3, 1, 4);
		g.print();
		
		g.reset();
		g = new SimpleWeightedMatrixGraph(4, true).addEdge(0, 1,7).addEdge(0,3, 4).addEdge(1, 2, 3).addEdge(3, 2, 3).addEdge(3, 1, 9);
		g.print();
		
		g.reset();
		g = new StringMatrixGraph(4).addEdge("A","B").addEdge("B","C").addEdge("B","D").addEdge("D","A");
		g.print();
		
		g.reset();
		g = new StringMatrixGraph(4, true).addEdge("A","B").addEdge("B","C").addEdge("B","D").addEdge("D","A");
		g.print();
		
		g.reset();
		g = new StringWeightedMatrixGraph(4).addEdge("A","B", 6).addEdge("B","C",9).addEdge("B","D",3).addEdge("D","A",11);
		g.print();
		
		g.reset();
		g = new StringWeightedMatrixGraph(4, true).addEdge("A","B", 6).addEdge("B","C",9).addEdge("B","D",3).addEdge("D","A",11);
		g.print();
	}
	
	private static void adjacencyListRepresentation() {
		Graph g = new SimpleAdjacencyListGraph(4).addEdge(0, 1).addEdge(1, 2).addEdge(2, 3).addEdge(3, 1);
		g.print();
		
		g.reset();
		g = new SimpleAdjacencyListGraph(4, true).addEdge(0, 1).addEdge(0,3).addEdge(1, 2).addEdge(3, 2).addEdge(3, 1);
		g.print();
		
		g.reset();
		g = new SimpleWeightedAdjacencyListGraph(4).addEdge(0, 1, 3).addEdge(1, 2, 5).addEdge(2, 3, 4).addEdge(3, 1, 4);
		g.print();
		
		g.reset();
		g = new SimpleWeightedAdjacencyListGraph(4, true).addEdge(0, 1,7).addEdge(0,3, 4).addEdge(1, 2, 3).addEdge(3, 2, 3).addEdge(3, 1, 9);
		g.print();
		
		g.reset();
		g = new StringAdjacencyListGraph(4).addEdge("A","B").addEdge("B","C").addEdge("B","D").addEdge("D","A");
		g.print();
		
		g.reset();
		g = new StringAdjacencyListGraph(4, true).addEdge("A","B").addEdge("B","C").addEdge("B","D").addEdge("D","A");
		g.print();
		
		g.reset();
		g = new StringWeightedAdjacencyListGraph(4).addEdge("A","B", 6).addEdge("B","C",9).addEdge("B","D",3).addEdge("D","A",11);
		g.print();
		
		g.reset();
		g = new StringWeightedAdjacencyListGraph(4, true).addEdge("A","B", 6).addEdge("B","C",9).addEdge("B","D",3).addEdge("D","A",11);
		g.print();
	}


}
