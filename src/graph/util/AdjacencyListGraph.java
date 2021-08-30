package graph.util;

public abstract class AdjacencyListGraph implements Graph {
	
	protected String graphType;
	protected boolean isDirected;
	
	@Override
	public void print() {
		if(this.graphType==null)
			throw new RuntimeException("Graph not defined");
		
		System.out.println(this.graphType);
		
		printList();

	}
	
	public abstract void printList();
	
	public Graph addEdge(int u, int v) {
		return this;
	}
	public Graph addEdge(int u, int v, int weight) {
		return this;
	}
	public Graph addEdge(String u, String v) {
		return this;
	}
	@Override
	public Graph addEdge(String u, String v, int weight) {	
		return this;
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
