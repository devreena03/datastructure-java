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

public class StringAdjacencyListGraph extends AdjacencyListGraph {
	
	private static final String STRING_UNDIRECTED = "String Undirected Graph, AdjacencyList represenation";
	private static final String STRING_DIRECTED = "String directed Graph, AdjacencyList represenation";
	
	private Map<String, List<String>> vertexMap;
	
	private Set<String> isVisited;
	private String[] list;
	
	@Override
	public StringAdjacencyListGraph bfs() {
		
		isVisited = new HashSet<>();
		list = new String[vertexMap.size()];
		
		Queue<String> queue = new LinkedList<>();
		queue.add(vertexMap.entrySet().iterator().next().getKey());
		int i=0;
		
		while(!queue.isEmpty()) {
			String v = queue.poll();
			if(!isVisited.contains(v)) {
				list[i++] = v;
				queue.addAll(vertexMap.get(v));
				isVisited.add(v);
			}
		}
		return this;
	}
	
	@Override
	public StringAdjacencyListGraph dfs() {
		
		isVisited = new HashSet<>();
		list = new String[vertexMap.size()];
		
		Stack<String> stack = new Stack<>();
		stack.push(vertexMap.entrySet().iterator().next().getKey());
		int i=0;
		
		while(!stack.isEmpty()) {
			String v = stack.pop();
			if(!isVisited.contains(v)) {
				list[i++] = v;
				stack.addAll(vertexMap.get(v));
				isVisited.add(v);
			}
		}
		return this;
	}
	
	public String[] getList() {
		return this.list;
	}
	
	public Map<String, List<String>> get(){
		return this.vertexMap;
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

	public void print(String[] list) {
		System.out.print("[");
		for(String a: list) {
			System.out.print(a+", ");
		}
		System.out.println("]");
	}
	
	public StringAdjacencyListGraph(int vertex) {
		this.graphType = STRING_UNDIRECTED;
		this.isDirected = false;
		this.vertexMap = new HashMap<>();
		
	}
	
	public StringAdjacencyListGraph(int vertex, boolean isDirected) {
		if(isDirected) {
			this.graphType = STRING_DIRECTED;
		} else {
			this.graphType = STRING_UNDIRECTED;
		}
		this.isDirected = isDirected;
		this.vertexMap = new HashMap<>();
		
	}
	
	@Override
	public StringAdjacencyListGraph addEdge(String u, String v) {
		addVertexInMap(u, v);
		if(!isDirected) {
			addVertexInMap(v, u);
		}
		return this;
	}

	private void addVertexInMap(String u, String v) {
		if(!vertexMap.containsKey(u)) {
			vertexMap.put(u, new ArrayList<>());
		}
		vertexMap.get(u).add(v);
	}
	
	public void printList() {
		for(String key: vertexMap.keySet()) {
			System.out.print(key+"-->");
			for (String a: vertexMap.get(key)) {
				System.out.print(a+", ");
			}
			System.out.println();
		}
		
	}
	
}
