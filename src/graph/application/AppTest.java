package graph.application;

import java.util.Arrays;
import java.util.List;

public class AppTest {
	
	
	public static void main(String[] args) {
		
		CycleDetection detection = new CycleDetection();
		List<Vertex> graph = createGraph();
		
		for(Vertex v: graph) {
			if(!v.isVisited()) {
				detection.dfs(v);
			}
		}
		
	}

	private static List<Vertex> createGraph() {
		
		//AdjacencyList representation
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		
		v1.addNeighbor(v2);
		v1.addNeighbor(v3);
		v2.addNeighbor(v3);
		v4.addNeighbor(v1);
		v4.addNeighbor(v5);
		v5.addNeighbor(v6);
		v6.addNeighbor(v4);
		
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
		
		return Arrays.asList(v1, v6, v2, v3, v4, v5);
		
	}
	
}
