package graph.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javafx.util.Pair;

public class SimpleWeightedAdjacencyListGraph extends AdjacencyListGraph {
	
	private static final String SIMPLE_DIRECTED_WEIGHTED = "Simple directed and wighted Graph, AdjacencyList represenation";
	private static final String SIMPLE_UNDIRECTED_WEIGHTED = "Simple un-directed and wighted Graph, AdjacencyList represenation";

	private ArrayList<Pair<Integer, Integer>>[] adjacencyListWeighted;
	
	private boolean[] isVisited;
	private int[] list;
	
	public SimpleWeightedAdjacencyListGraph(int vertex) {
		this.graphType = SIMPLE_UNDIRECTED_WEIGHTED;
		this.isDirected = false;
		createEmptyGraph(vertex);
		
	}
	
	public SimpleWeightedAdjacencyListGraph(int vertex, boolean isDirected) {
		if(isDirected) {
			this.graphType = SIMPLE_DIRECTED_WEIGHTED;
		} else {
			this.graphType = SIMPLE_UNDIRECTED_WEIGHTED;
		}
		this.isDirected = isDirected;
		createEmptyGraph(vertex);
		
	}
	
	@Override
	public SimpleWeightedAdjacencyListGraph addEdge(int u, int v, int weight) {
		adjacencyListWeighted[u].add(new Pair<Integer, Integer>(v, weight));
		if(!this.isDirected) {
			adjacencyListWeighted[v].add(new Pair<Integer, Integer>(u, weight));
		}
		return this;
	}
	
	public ArrayList<Pair<Integer, Integer>>[] get(){
		return this.adjacencyListWeighted;
	}
	
	
	@Override
	public SimpleWeightedAdjacencyListGraph bfs() {
		
		isVisited = new boolean[adjacencyListWeighted.length];
		list = new int[adjacencyListWeighted.length];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int i=0;
		while(!queue.isEmpty()) {
			int v = queue.poll();
			if(!isVisited[v]) {
				list[i++] = v;
				for (Pair<Integer, Integer> pair: adjacencyListWeighted[v]) {
					queue.add(pair.getKey());
				}
				isVisited[v] = true;
			}
		}
		return this;
	}
	
	@Override
	public SimpleWeightedAdjacencyListGraph dfs() {
		
		isVisited = new boolean[adjacencyListWeighted.length];
		list = new int[adjacencyListWeighted.length];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int i=0;
		
		while(!stack.isEmpty()) {
			int v = stack.pop();
			if(!isVisited[v]) {
				list[i++] = v;
				for (Pair<Integer, Integer> pair: adjacencyListWeighted[v]) {
					stack.push(pair.getKey());
				}
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
	
	
	private void createEmptyGraph(int vertex) {
		adjacencyListWeighted = new ArrayList[vertex];
		for(int i=0; i<vertex; i++) {
			adjacencyListWeighted[i] = new ArrayList<Pair<Integer,Integer>>();
		}
	}
	
	public void printList() {
		for(int i=0; i< adjacencyListWeighted.length; i++) {
			System.out.print(i+"-->");
			for (Pair<Integer, Integer> pair: adjacencyListWeighted[i]) {
				System.out.print(pair.getKey()+"("+pair.getValue()+")" +", ");
			}
			System.out.println();
		}
		
	}
	
}
