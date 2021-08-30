package graph.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SimpleAdjacencyListGraph extends AdjacencyListGraph {
	
	private static final String SIMPLE_UNDIRECTED = "Simple Undirected Graph, AdjacencyList represenation";
	private static final String SIMPLE_DIRECTED = "Simple directed Graph, AdjacencyList represenation";
	
	private ArrayList<Integer>[] adjacencyList;
	private boolean[] isVisited;
	private int[] list;
	
	public SimpleAdjacencyListGraph(int vertex) {
		this.graphType = SIMPLE_UNDIRECTED;
		this.isDirected = false;
		createEmptyGraph(vertex);
		
	}
	
	public SimpleAdjacencyListGraph(int vertex, boolean isDirected) {
		if(isDirected) {
			this.graphType = SIMPLE_DIRECTED;
		} else {
			this.graphType = SIMPLE_UNDIRECTED;
		}
		this.isDirected = isDirected;
		createEmptyGraph(vertex);
		
	}
	
	@Override
	public SimpleAdjacencyListGraph addEdge(int u, int v) {
		adjacencyList[u].add(v);
		if(!isDirected) {
			adjacencyList[v].add(u);
		}
		return this;
	}
	
	public ArrayList<Integer>[] get(){
		return this.adjacencyList;
	}
	
	private void createEmptyGraph(int vertex) {
		adjacencyList = new ArrayList[vertex];
		for(int i=0; i<vertex; i++) {
			adjacencyList[i] = new ArrayList<Integer>();
		}
	}
	
	@Override
	public SimpleAdjacencyListGraph bfs() {
		
		isVisited = new boolean[adjacencyList.length];
		list = new int[adjacencyList.length];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int i=0;
		while(!queue.isEmpty()) {
			int v = queue.poll();
			if(!isVisited[v]) {
				list[i++] = v;
				queue.addAll(adjacencyList[v]);
				isVisited[v] = true;
			}
		}
		return this;
	}
	
	@Override
	public SimpleAdjacencyListGraph dfs() {
		
		isVisited = new boolean[adjacencyList.length];
		list = new int[adjacencyList.length];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int i=0;
		
		while(!stack.isEmpty()) {
			int v = stack.pop();
			if(!isVisited[v]) {
				list[i++] = v;
				stack.addAll(adjacencyList[v]);
				isVisited[v] = true;
			}
		}
		return this;
	}
	
	public int[] getList() {
		return this.list;
	}
	
	@Override
	public void printBfs() {
		this.bfs();
		print(list);
	}
	
	@Override
	public void printDfs() {
		this.dfs();
		print(list);
	}

	private void print(int[] list) {
		System.out.print("[");
		for(int a: list) {
			System.out.print(a+", ");
		}
		System.out.println("]");
	}
	
	public void printList() {
		for(int i=0; i< adjacencyList.length; i++) {
			System.out.print(i+"-->");
			for (int a: adjacencyList[i]) {
				System.out.print(a+", ");
			}
			System.out.println();
		}
		
	}
	
}
