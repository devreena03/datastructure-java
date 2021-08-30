package graph.util;

import java.util.HashMap;

public class StringMatrixGraph extends MatrixGraph {
	
	private static final String STRING_UNDIRECTED = "String Undirected Graph, Matrix represenation";
	private static final String STRING_DIRECTED = "String directed Graph, Matrix represenation";
	
	public StringMatrixGraph(int vertex) {
		this.graphType = STRING_UNDIRECTED;
		this.isDirected = false;
		this.vertexMap = new HashMap<>();
		this.matrix = new int[vertex][vertex];
		
	}
	
	public StringMatrixGraph(int vertex, boolean isDirected) {
		if(isDirected) {
			this.graphType = STRING_DIRECTED;
		} else {
			this.graphType = STRING_UNDIRECTED;
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
