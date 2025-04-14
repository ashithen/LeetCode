package org.example.meta;

import java.util.HashSet;
import java.util.Set;

public class LowestCP {

    int maxDepth;
    Set<Integer> leavesSet;
    TreeNode parent;

    private void traverse(TreeNode node, int depth) {
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            if (depth > maxDepth){
                maxDepth = depth;
                leavesSet = new HashSet<>();
                leavesSet.add(node.val);
            } else if (depth == maxDepth) {
                leavesSet.add(node.val);
            }
            return;
        }
        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }

    private Set<Integer> commonParent(TreeNode node, int depth) {
        if (node == null){
            return new HashSet<>();
        }
        Set<Integer> result = new HashSet<>();
        if (depth == maxDepth){
            result.add(node.val);
        }
        else {
            result.addAll(commonParent(node.left, depth + 1));
            result.addAll(commonParent(node.right, depth + 1));
        }
        if (parent == null && result.equals(leavesSet)){
            parent = node;
        }
        return result;
    }



    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = 0;
        leavesSet = new HashSet<>();
        parent = null;
        traverse(root, 0);
        commonParent(root, 0);
        return parent;
    }
}
