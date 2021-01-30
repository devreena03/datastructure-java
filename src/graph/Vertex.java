package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private String name;
	private boolean visited;
	private List<Vertex> adjacencyList;

	public Vertex(String name) {
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}
	
	public void addNeighbor(Vertex v) {
		this.adjacencyList.add(v);
	}
	
	public void showNeighbors() {
		System.out.print(this.name+" neighbor vertex: ");
		for(Vertex v: this.adjacencyList) {
			System.out.print(v + " ");
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public List<Vertex> getAdjacencyList(){
		return this.adjacencyList;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	

}
