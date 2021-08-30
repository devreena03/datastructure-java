package graph.node.weighted;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Node<T> {
	
	private T val;
	LinkedList<Edge<T>> edges;
	
	public Node(T val) {
		super();
		this.setVal(val);
		this.edges = new LinkedList<>();
	}
	
	public Node(T val, LinkedList<Edge<T>> edges) {
		super();
		this.setVal(val);
		this.edges = edges;
	}
	
	public void addEdge(Node<T> u, Node<T> v, int w) {
		Edge<T> edge = new Edge<>(u,v,w);
		this.edges.add(edge);
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	public LinkedList<Edge<T>> getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Edge<T>> edges) {
		this.edges = edges;
	}
	
	public List<Node<T>> getAllNeighbors() {
		return (List<Node<T>>) edges.stream().map(n->n.dest).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
    	for(Edge<T> e: edges)
    		sb.append(e).append(",");
    	
		return "val=" + getVal() + ", edges=" + edges + "]";
	}

	

}
