package graph.util;

public class SimpleWeightedMatrixGraph extends MatrixGraph {
	private static final String SIMPLE_DIRECTED_WEIGHTED = "Simple directed and wighted Graph, Matrix represenation";
	private static final String SIMPLE_UNDIRECTED_WEIGHTED = "Simple un-directed and wighted Graph, Matrix represenation";
	
	public SimpleWeightedMatrixGraph(int vertex) {
		this.graphType = SIMPLE_UNDIRECTED_WEIGHTED;
		this.isDirected = false;
		this.matrix = new int[vertex][vertex];
		
	}
	
	public SimpleWeightedMatrixGraph(int vertex, boolean isDirected) {
		if(isDirected) {
			this.graphType = SIMPLE_DIRECTED_WEIGHTED;
		} else {
			this.graphType = SIMPLE_UNDIRECTED_WEIGHTED;
		}
		this.isDirected = isDirected;
		this.matrix = new int[vertex][vertex];
		
	}
	
}
