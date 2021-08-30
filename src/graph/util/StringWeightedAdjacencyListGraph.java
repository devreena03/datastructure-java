package graph.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javafx.util.Pair;

public class StringWeightedAdjacencyListGraph extends AdjacencyListGraph {
	
	private static final String STRING_DIRECTED_WEIGHTED = "String directed and wighted Graph, AdjacencyList represenation";
	private static final String STRING_UNDIRECTED_WEIGHTED = "String Undirected and wighted Graph, AdjacencyList represenation";
	
	Map<String, ArrayList<Pair<String, Integer>>> vertexMapWeighted;
	private Set<String> isVisited;
	private String[] bfsList;
	private String[] dfsList;
	
	@Override
	public StringWeightedAdjacencyListGraph bfs() {
		
		isVisited = new HashSet<>();
		bfsList = new String[vertexMapWeighted.size()];
		dfsList = null;
		
		Queue<String> queue = new LinkedList<>();
		queue.add(vertexMapWeighted.entrySet().iterator().next().getKey());
		int i=0;
		
		while(!queue.isEmpty()) {
			String v = queue.poll();
			if(!isVisited.contains(v)) {
				bfsList[i++] = v;
				for (Pair<String, Integer> pair: vertexMapWeighted.get(v)) {
					queue.add(pair.getKey());
				}
				isVisited.add(v);
			}
		}
		return this;
	}
	
	@Override
	public StringWeightedAdjacencyListGraph dfs() {
		
		isVisited = new HashSet<>();
		dfsList = new String[vertexMapWeighted.size()];
		bfsList = null;
		
		Stack<String> stack = new Stack<>();
		stack.push(vertexMapWeighted.entrySet().iterator().next().getKey());
		int i=0;
		
		while(!stack.isEmpty()) {
			String v = stack.pop();
			if(!isVisited.contains(v)) {
				dfsList[i++] = v;
				for (Pair<String, Integer> pair: vertexMapWeighted.get(v)) {
					stack.push(pair.getKey());
				}
				isVisited.add(v);
			}
		}
		return this;
	}
	
	public String[] getList() {
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

	private void print(String[] list) {
		System.out.print("[");
		for(String a: list) {
			System.out.print(a+", ");
		}
		System.out.println("]");
	}
	
	public StringWeightedAdjacencyListGraph(int vertex) {
		this.graphType = STRING_UNDIRECTED_WEIGHTED;
		this.isDirected = false;
		this.vertexMapWeighted = new HashMap<>();
		
	}
	
	public StringWeightedAdjacencyListGraph(int vertex, boolean isDirected) {
		if(isDirected) {
			this.graphType = STRING_UNDIRECTED_WEIGHTED;
		} else {
			this.graphType = STRING_DIRECTED_WEIGHTED;
		}
		this.isDirected = isDirected;
		this.vertexMapWeighted = new HashMap<>();
		
	}
	
	@Override
	public Graph addEdge(String u, String v, int weight) {
		addPairVertexInMap(u, new Pair<String, Integer>(v, weight));
		if(this.graphType == STRING_UNDIRECTED_WEIGHTED) {
			addPairVertexInMap(v, new Pair<String, Integer>(u, weight));
		}
		return this;
	}
	
	private void addPairVertexInMap(String u, Pair<String, Integer> pair) {
		if(!vertexMapWeighted.containsKey(u)) {
			vertexMapWeighted.put(u, new ArrayList<>());
		}
		vertexMapWeighted.get(u).add(pair);
	}
	
	public void printList() {
		for(String key: vertexMapWeighted.keySet()) {
			System.out.print(key + "-->");
			for (Pair<String, Integer> pair: vertexMapWeighted.get(key)) {
				System.out.print(pair.getKey()+"("+pair.getValue()+")" +", ");
			}
			System.out.println();
		}
		
	}
	
}
