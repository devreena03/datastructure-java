package graph.application;

public class CycleDetection {
	
	public void dfs(Vertex vertex) {
		
		vertex.setBeingVisited(true);
		for (Vertex v: vertex.getAdjacencyList()) {
			if(v.isBeingVisited()) {
				System.out.println("Cycle detection vertex->" + v);
				return;
			} 
			
			if(!v.isVisited()) {
				dfs(v);
			}
			
		}
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
		
	}

}
