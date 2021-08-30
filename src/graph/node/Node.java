package graph.node;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
   
	public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
    
    @Override
   	public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for(Node n: neighbors)
    		sb.append(n.val).append(",");
    	
   		return "Node [val=" + val + ", neighbors=" + sb.toString() + "]";
   	}

}
