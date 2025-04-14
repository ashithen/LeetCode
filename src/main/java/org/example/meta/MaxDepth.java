package org.example.meta;

import java.util.HashSet;
import java.util.Set;

public class MaxDepth {

    int maxDepth;
    Set<Integer> leaves;
    boolean isSingleMaxDepth;
    TreeNode ans;

    private void traverse(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                leaves = new HashSet<>();
                leaves.add(node.val);
            } else if (depth == maxDepth) {
                leaves.add(node.val);
            }
            return;
        }
        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }

    private void findCommonParent(TreeNode node) {
        if (node == null) {
            return;
        }
        if (leaves.contains(node.val)) {
            leaves.remove(node.val);
            if (isSingleMaxDepth) {
                ans = node;
            }
            return;
        }
        findCommonParent(node.left);
        findCommonParent(node.right);
        if (ans == null && leaves.isEmpty()){
            ans = node;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = 0;
        leaves = new HashSet<>();
        traverse(root, 0);
        isSingleMaxDepth = leaves.size() == 1;
        ans = null;
        findCommonParent(root);
        return ans;
    }
}
