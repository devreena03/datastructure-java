package graph.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GenericAdjacencyListGraph<T> extends AdjacencyListGraph{

	private static final String UNDIRECTED = "Generic Undirected Graph, AdjacencyList represenation";
	private static final String DIRECTED = "Generic directed Graph, AdjacencyList represenation";
	
	private Map<T, List<T>> vertexMap;
	
	private Set<T> isVisited;
	private T[] bfsList;
	private T[] dfsList;
	
	public GenericAdjacencyListGraph() {
		this.graphType = UNDIRECTED;
		this.isDirected = false;
		this.vertexMap = new HashMap<>();
		
	}
	
	public GenericAdjacencyListGraph(boolean isDirected) {
		if(isDirected) {
			this.graphType = DIRECTED;
		} else {
			this.graphType = UNDIRECTED;
		}
		this.isDirected = isDirected;
		this.vertexMap = new HashMap<>();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public GenericAdjacencyListGraph<T> bfs() {
		
		isVisited = new HashSet<>();
		bfsList= (T[]) new Object[vertexMap.size()];
		dfsList = null;
		
		Queue<T> queue = new LinkedList<>();
		queue.add(vertexMap.entrySet().iterator().next().getKey());
		int i=0;
		
		while(!queue.isEmpty()) {
			T v = queue.poll();
			if(!isVisited.contains(v)) {
				bfsList[i++] = v;
				queue.addAll(vertexMap.get(v));
				isVisited.add(v);
			}
		}
		return this;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public GenericAdjacencyListGraph<T> dfs() {
		
		isVisited = new HashSet<>();
		dfsList = (T[]) new Object[vertexMap.size()];
		bfsList = null;
		
		Stack<T> stack = new Stack<>();
		stack.push(vertexMap.entrySet().iterator().next().getKey());
		int i=0;
		
		while(!stack.isEmpty()) {
			T v = stack.pop();
			if(!isVisited.contains(v)) {
				dfsList[i++] = v;
				stack.addAll(vertexMap.get(v));
				isVisited.add(v);
			}
		}
		return this;
	}
	
	public T[] getList() {
		return bfsList==null? this.dfsList : this.bfsList;
	}
	
	@Override
	public void printBfs() {
		this.bfs();
		print(bfsList);
	}
	
	@Override
	public void printDfs() {
		this.dfs();
		print(dfsList);
	}

	private void print(T[] list) {
		System.out.print("[");
		for(T a: list) {
			System.out.print(a+", ");
		}
		System.out.println("]");
	}
	
	public GenericAdjacencyListGraph<T> addEdgeT(T u, T v) {
		addVertexInMap(u, v);
		if(!isDirected) {
			addVertexInMap(v, u);
		}
		return this;
	}
	
	public GenericAdjacencyListGraph<T> removeEdge(T u, T v){
		vertexMap.get(u).remove(v);
		if(!isDirected) {
			vertexMap.get(v).remove(u);
		}
		return this;
	}

	public GenericAdjacencyListGraph<T> removeVertex(T u){
		vertexMap.values().stream().forEach(e -> e.remove(u));
		vertexMap.remove(u);
		return this;
	}

	private void addVertexInMap(T u, T v) {
		if(!vertexMap.containsKey(u)) {
			vertexMap.put(u, new ArrayList<>());
		}
		vertexMap.get(u).add(v);
	}
	
	public void printList() {
		for(T key: vertexMap.keySet()) {
			System.out.print(key+"-->");
			for (T a: vertexMap.get(key)) {
				System.out.print(a+", ");
			}
			System.out.println();
		}
	}
		

}
