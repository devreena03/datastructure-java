package graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AppTest {
	
	
	public static void main(String[] args) {
		
		TopologicalSort topo = new TopologicalSort();
		List<Vertex> graph = createGraph();
		
		for(Vertex v: graph) {
			if(!v.isVisited()) {
				topo.dfs(v);
			}
		}
		
		Stack<Vertex> stack = topo.getStack();
		while(!stack.isEmpty()) {
			Vertex v = stack.pop();
			System.out.println(v + " ->");
			
		}
	}

	private static List<Vertex> createGraph() {
		
		//AdjacencyList representation
		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		
		v2.addNeighbor(v3);
		v3.addNeighbor(v1);
		v4.addNeighbor(v0);
		v4.addNeighbor(v1);
		v5.addNeighbor(v0);
		v5.addNeighbor(v2);
		
//		Vertex a = new Vertex("A");
//		Vertex b = new Vertex("B");
//		Vertex c = new Vertex("C");
//		Vertex d = new Vertex("D");
//		Vertex e = new Vertex("E");
//		
//		a.addNeighbor(c);
//		a.addNeighbor(d);
//		c.addNeighbor(e);
//		c.addNeighbor(b);
//		b.addNeighbor(d);
//		e.addNeighbor(d);
//		e.addNeighbor(b);
		
		//return Arrays.asList(a,b,c,d,e);
		
		return Arrays.asList(v0, v1, v2, v3, v4, v5);
		
	}
	
}
