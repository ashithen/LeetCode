package org.example.meta;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> nodeStack;

    private void addLeftNodes(TreeNode node){
        while (node != null){
            nodeStack.add(node);
            node = node.left;
        }
    }

    public BSTIterator(TreeNode root) {
        nodeStack = new Stack<>();
        addLeftNodes(root);
    }

    public int next() {
        TreeNode res = nodeStack.pop();
        addLeftNodes(res.right);
        return res.val;
    }

    public boolean hasNext() {
        return !this.nodeStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(Character.isDigit(' '));
    }
}
