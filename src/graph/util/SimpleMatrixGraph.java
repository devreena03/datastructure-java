package graph.util;

public class SimpleMatrixGraph extends MatrixGraph {
	private static final String SIMPLE_UNDIRECTED = "Simple Undirected Graph, Matrix represenation";
	private static final String SIMPLE_DIRECTED = "Simple directed Graph, Matrix represenation";
	
	public SimpleMatrixGraph(int vertex) {
		this.graphType = SIMPLE_UNDIRECTED;
		this.isDirected = false;
		this.matrix = new int[vertex][vertex];
		
	}
	
	public SimpleMatrixGraph(int vertex, boolean isDirected) {
		if(isDirected) {
			this.graphType = SIMPLE_DIRECTED;
		} else {
			this.graphType = SIMPLE_UNDIRECTED;
		}
		this.isDirected = isDirected;
		this.matrix = new int[vertex][vertex];
		
	}
	
	
}
