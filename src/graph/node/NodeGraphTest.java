package graph.node;

public class NodeGraphTest {
	
	public static void main(String[] args) {
		NodeGraph g = new NodeGraph()
				.addEdge(0, 1)
				.addEdge(0, 2)
				.addEdge(1, 3)
				.addEdge(2, 4)
				.addEdge(3, 5)
				.addEdge(3, 4)
				.addEdge(1, 4)
				.addEdge(4, 5);
		
			g.print();
			g.clone(g.head());
			g.printClone();
			
			//g.bfs(g.head()).stream().forEach(System.out::println);
//			g.dfs(g.head()).stream().forEach(System.out::println);
//			g.dfs(g.clone(g.head())).stream().forEach(System.out::println);
		
	}

}
