package org.example.meta;


import java.util.*;

public class TreeRightView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<Integer> output = new ArrayList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            output.add(nodeQueue.peek().val);
            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (!nodeQueue.isEmpty()){
                TreeNode node = nodeQueue.poll();
                if (node.right != null){
                    nextQueue.add(node.right);
                }
                if (node.left != null){
                    nextQueue.add(node.left);
                }
            }
            nodeQueue = nextQueue;
        }
        return output;
    }
}
