/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Map<Integer, Node> visitedNodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visitedNodes.containsKey(node.val)) {
            return visitedNodes.get(node.val);
        }
        Node cloneNode = new Node(node.val);
        visitedNodes.put(node.val, cloneNode);
        for (Node linkedNode : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(linkedNode));
        }
        return cloneNode;
    }
}