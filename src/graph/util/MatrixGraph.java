package graph.util;

import java.util.Map;

public class MatrixGraph implements Graph {
	
	int[][] matrix;
	
	Map<String, Integer> vertexMap;
	
    protected String graphType;
    boolean isDirected;
    
	@Override
	public void print()  {
		if(this.graphType==null)
			throw new RuntimeException("Graph not defined");
		
		System.out.println(this.graphType);
		System.out.print("[");
		if(this.graphType.startsWith("String")) {
			for (String s:vertexMap.keySet()) {
				System.out.print(s+":"+vertexMap.get(s)+", ");
			}		
		}
		System.out.println();
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j]+", ");
			}
			System.out.println();
		}
		System.out.println("]");
	}
	
	public int[][] get(){
		return this.matrix;
	}

	@Override
	public Graph dfs() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Graph bfs() {
		// TODO Auto-generated method stub
		return this;
	}
	
	@Override
	public void printBfs() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void printDfs() {
		// TODO Auto-generated method stub

	}

	@Override
	public Graph addEdge(int u, int v) {
		return this.addEdge(u, v, 1);
	}

	@Override
	public Graph addEdge(int u, int v, int weight) {
		this.matrix[u][v] = weight;		
		if(!isDirected)
			this.matrix[v][u] = weight;
		
		return this;
	}

	@Override
	public Graph addEdge(String u, String v, int weight) {

		this.matrix[getIndex(u)][getIndex(v)] = weight;
		
		if(!isDirected)
			this.matrix[getIndex(v)][getIndex(u)] = weight;
		
		return this;
	}
	
	@Override
	public Graph addEdge(String u, String v) {
		return this.addEdge(u, v, 1);
	}

	private int getIndex(String vertex) {
		if(!vertexMap.containsKey(vertex)) {
			vertexMap.put(vertex, vertexMap.size());
		}
			
		return vertexMap.get(vertex);
	}

	@Override
	public void reset() {
		this.graphType = null;	
	}

	@Override
	public String currentGraphType() {
		return this.graphType;
	}

}
