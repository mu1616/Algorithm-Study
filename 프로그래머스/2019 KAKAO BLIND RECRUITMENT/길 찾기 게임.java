import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i = 0; i < nodeinfo.length; i++) 
        	nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        
        Arrays.sort(nodes, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return (n2.y == n1.y) ? (n1.x - n2.x): (n2.y - n1.y); 
			}       	
        });
        
        Node root = nodes[0];
        
        for(int i = 1; i < nodes.length; i++) {
        	insert(root, nodes[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();        
        beforeSearch(root, list);
        
        for(int i = 0; i < list.size(); i++) 
        	answer[0][i] = list.get(i);
        
        list.clear();
        afterSearch(root, list);
        
        for(int i = 0; i < list.size(); i++)
        	answer[1][i] = list.get(i);
        
        return answer;
    }
    
    public void afterSearch(Node root, List<Integer> list) {
    	if(root.left != null)
    		afterSearch(root.left, list);
    	
    	if(root.right != null)
    		afterSearch(root.right, list);
    	
    	list.add(root.idx);
    }
    
    public void beforeSearch(Node root, List<Integer> list) {
    	list.add(root.idx);
    	
    	if(root.left != null)
    		beforeSearch(root.left, list);
    	
    	if(root.right != null)
    		beforeSearch(root.right, list);
    }
    
    public void insert(Node root, Node node) {
    	if(root.x > node.x) {
    		if(root.left != null) 
    			insert(root.left, node);
    		 else 
    			root.left = node;    		
    		
    	} else {
    		if(root.right != null)
    			insert(root.right, node);
    		else
    			root.right = node;
    	}
    }
    
    class Node {
    	int x;
    	int y;
    	int idx;
    	Node left;
    	Node right;
    	
    	Node(int x, int y, int idx)  {
    		this.x = x;
    		this.y = y;
    		this.idx = idx;
    	}
    }
}