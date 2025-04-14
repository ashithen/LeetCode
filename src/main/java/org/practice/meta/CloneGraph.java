package org.practice.meta;


import java.util.ArrayList;
import java.util.List;

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
public class CloneGraph {
    boolean[] isVisited;
    Node[] newNodes;

    private Node createAndGetNode(int v){
        if (newNodes[v] == null){
            newNodes[v] = new Node(v);
        }
        return newNodes[v];
    }

    private void clone(Node node){
        if (isVisited[node.val]){
            return;
        }
        isVisited[node.val] = true;
        Node newNode = this.createAndGetNode(node.val);
        for (Node oldN : node.neighbors){
            newNode.neighbors.add(this.createAndGetNode(oldN.val));
            this.clone(oldN);
        }
    }
    public Node cloneGraph(Node node) {
        isVisited = new boolean[101];
        newNodes = new Node[101];
        this.clone(node);
        return this.newNodes[1];
    }
}
