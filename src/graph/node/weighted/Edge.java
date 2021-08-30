package graph.node.weighted;

public class Edge<T> {
	
	Node<T> source;
	Node<T> dest;
	
	int weight;

	public Edge(Node<T> source, Node<T> dest, int weight) {
		super();
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
	
	public String edge() {
		return dest.getVal() + "(" + weight + "),";
	}

	@Override
	public String toString() {
		return "Edge [source=" + source.getVal() + ", dest=" + dest.getVal() + ", weight=" + weight + "]";
	}

}
