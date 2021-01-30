package graph;

public class GraphRepresenation {
	
	private static int[][] adjacencyMatrix = {
			{0, 2, 4, 0},
			{0, 0, 0, 3},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
	};
	
	public static void main(String[] args) {
		
		for(int i=0; i<adjacencyMatrix.length; i++) {
			for(int j=0; j<adjacencyMatrix.length;j++) {
				if(adjacencyMatrix[i][j]!=0) {
					System.out.println("Edges with value:"+ adjacencyMatrix[i][j]);
				}
			}
		}
		
		//AdjacencyList representation
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		
		a.addNeighbor(b);
		a.addNeighbor(c);
		b.addNeighbor(d);
		
		//print all neighbor
		a.showNeighbors();
		b.showNeighbors();
		c.showNeighbors();
		d.showNeighbors();
		
	}

}
