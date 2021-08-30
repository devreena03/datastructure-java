package graph.util;

import java.util.HashMap;

public class StringWeightedMatrixGraph extends MatrixGraph {
	
	private static final String STRING_DIRECTED_WEIGHTED = "String directed and wighted Graph, Matrix represenation";
	private static final String STRING_UNDIRECTED_WEIGHTED = "String Undirected and wighted Graph, Matrix represenation";
	
	public StringWeightedMatrixGraph(int vertex) {
		this.graphType = STRING_UNDIRECTED_WEIGHTED;
		this.isDirected = false;
		this.vertexMap = new HashMap<>();
		this.matrix = new int[vertex][vertex];
		
	}
	
	public StringWeightedMatrixGraph(int vertex, boolean isDirected) {
		if(isDirected) {
			this.graphType = STRING_DIRECTED_WEIGHTED;
		} else {
			this.graphType = STRING_UNDIRECTED_WEIGHTED;
		}
		this.isDirected = isDirected;
		this.vertexMap = new HashMap<>();
		this.matrix = new int[vertex][vertex];
		
	}
	
	public String[] getStringVertex(){
		String[] list = new String[matrix.length];
		for (String s:vertexMap.keySet()) {
			list[vertexMap.get(s)] = s;
		}
		return list;
	}
	
}
