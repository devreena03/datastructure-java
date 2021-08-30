package graph.node.weighted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WeightedGraph<T> {
	
	private Map<T, Node<T>> container;
	private boolean isDirected;
	private List<T> list;
	private Set<T> isVisited;
	
	WeightedGraph(){
		container = new HashMap<>();
		this.isDirected = false;
	}
	
	WeightedGraph(boolean isDirected){
		container = new HashMap<>();
		this.isDirected = isDirected;
	}
	
	public WeightedGraph<T> addEdge(T u, T v, int w) {
		Node<T> node1 = getNodeByValue(u);
		Node<T> node2 = getNodeByValue(v);
		
		node1.addEdge(node1, node2, w);
		if(!isDirected) {
			node2.addEdge(node2, node1, w);
		}
		
		return this;
	}
	
	private Node<T> getNodeByValue(T val) {
		if(!container.containsKey(val)) {		
			container.put(val, new Node<T>(val));
		}
		return container.get(val);
	}
	
	public Node<T> head() {
		return this.container.get(this.container.keySet().iterator().next());
	}
	
	public void print() {
		System.out.println((isDirected?"Directed":"Undirected")+ " weighted graph***********");
		for(T key: this.container.keySet()) {
			Node<T> node = this.container.get(key);
			System.out.print(node.getVal()+"-->");
			for(Edge<T> e: node.edges) {
				System.out.print(e.edge());
			}
			System.out.println();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(T key: this.container.keySet()) 
    		sb.append(this.container.get(key)).append("\n");
    	
		return sb.toString();
	}
	

	public List<T> bfs(Node<T> node) {
		list = new ArrayList<>();
		isVisited = new HashSet<>();
		
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			node = queue.poll();
			if(!isVisited.contains(node.getVal())) {
				isVisited.add(node.getVal());
				list.add(node.getVal());
				queue.addAll(node.getAllNeighbors());
			}
		}
		return list;
	}
	
	public List<T> dfs(Node<T> node) {
		list = new ArrayList<>();
		isVisited = new HashSet<>();
		
		dfsearch(node);
		
		return list;
	}
	
	private void dfsearch(Node<T> node) {
		if(isVisited.contains(node.getVal())) return;
		
		isVisited.add(node.getVal());
		list.add(node.getVal());
		
		for(Node<T> n: node.getAllNeighbors())
			dfsearch(n);
		
	}


}
