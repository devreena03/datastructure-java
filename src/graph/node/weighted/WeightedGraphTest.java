package graph.node.weighted;

public class WeightedGraphTest {
	
	public static void main(String[] args) {
//		WeightedGraph<Integer> g = new WeightedGraph<Integer>()
//				.addEdge(0, 1, 3)
//				.addEdge(0, 2, 4)
//				.addEdge(1, 3, 3)
//				.addEdge(2, 4, 6)
//				.addEdge(3, 5, 3)
//				.addEdge(3, 4, 7)
//				.addEdge(1, 4, 4)
//				.addEdge(4, 5, 2);
		
		WeightedGraph<String> g = new WeightedGraph<String>(true)
				.addEdge("A", "B", 3)
				.addEdge("A", "C", 4)
				.addEdge("B", "D", 6)
				.addEdge("C", "E", 6)
				.addEdge("D", "F", 3)
				.addEdge("D", "E", 7)
				.addEdge("B", "E", 4)
				.addEdge("E", "F", 6);
		
			System.out.println(g);
			
			g.print();
			
			g.bfs(g.head()).stream().forEach(System.out::println);
			g.dfs(g.head()).stream().forEach(System.out::println);
		
	}

}
