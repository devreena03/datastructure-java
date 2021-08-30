package graph.util;

public interface Graph {
	
	public Graph addEdge(int u, int v);
	public Graph addEdge(int u, int v, int weight);
	
	public Graph addEdge(String u, String v);
	public Graph addEdge(String u, String v, int weight);
	
	public void print();
	public Graph dfs();
	public Graph bfs();
	
	public void printBfs();
	public void printDfs();
	
	public void reset();
	public String currentGraphType();
	
}
