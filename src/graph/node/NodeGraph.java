package graph.node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class NodeGraph {
	
	Map<Integer, Node> container;
	Map<Integer, Node> cloneMap;
	
	boolean isDirected;
	
	List<Integer> list;
	Set<Node> isVisited;
	
	NodeGraph(){
		container = new HashMap<>();
		this.isDirected = false;
	}
	
	NodeGraph(boolean isDirected){
		container = new HashMap<>();
		this.isDirected = isDirected;
	}
	
	public NodeGraph addEdge(int u, int v) {
		Node node1 = getNodeByValue(u);
		Node node2 = getNodeByValue(v);
		
		node1.neighbors.add(node2);
		if(!isDirected) {
			node2.neighbors.add(node1);
		}
		
		return this;
	}
	
	public Node head() {
		return this.container.get(this.container.keySet().iterator().next());
	}
	
	public Node clone(Node node) {
		isVisited = new HashSet<>();
		cloneMap = new HashMap<>();
		return cloneNode(node);
	}
	
	private Node cloneNode(Node node) {
		
		if(!isVisited.contains(node)) {
		
			isVisited.add(node);
			Node n = getFromCloneMap(node.val);
			for(Node c: node.neighbors) {
				n.neighbors.add(cloneNode(c));
			}
			return n;
		}
		
		return cloneMap.get(node.val);
		
	}

	private Node getFromCloneMap(int val) {
		if(!cloneMap.containsKey(val)) {		
			cloneMap.put(val, new Node(val));
		}
		return cloneMap.get(val);
	}
	
	public void printClone() {
		System.out.println("Clone graph");
		for(Integer key: this.cloneMap.keySet()) {
			System.out.println(this.cloneMap.get(key));
		}
	}


	public List<Integer> bfs(Node node) {
		list = new ArrayList<>();
		isVisited = new HashSet<>();
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			node = queue.poll();
			if(!isVisited.contains(node)) {
				isVisited.add(node);
				list.add(node.val);
				queue.addAll(node.neighbors);
			}
			
		}
		
		return list;
	}
	
	public List<Integer> dfs(Node node) {
		list = new ArrayList<>();
		isVisited = new HashSet<>();
		
		dfsearch(node);
		
		return list;
	}
	
	private void dfsearch(Node node) {
		if(isVisited.contains(node)) return;
		
		isVisited.add(node);
		list.add(node.val);
		
		for(Node n: node.neighbors)
			dfsearch(n);
		
	}

	public List<Integer> dfsItr(Node node) {
		list = new ArrayList<>();
		isVisited = new HashSet<>();
		
		Stack<Node> stack = new Stack<>();
		stack.add(node);
		while(!stack.isEmpty()) {
			node = stack.pop();
			if(!isVisited.contains(node)) {
				isVisited.add(node);
				list.add(node.val);
				stack.addAll(node.neighbors);
			}
			
		}
		
		return list;
	}
	
	public void print() {
		System.out.println("******** graph***********");
		for(Integer key: this.container.keySet()) {
			System.out.println(this.container.get(key));
		}
	}
	
	private Node getNodeByValue(int val) {
		if(!container.containsKey(val)) {		
			container.put(val, new Node(val));
		}
		return container.get(val);
	}
	

}
