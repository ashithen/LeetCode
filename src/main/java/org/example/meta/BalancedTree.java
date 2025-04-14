package org.example.meta;

public class BalancedTree {

    private int maxLevel;
    private boolean isDecreased;

    private boolean checkBalance(TreeNode node, int level) {
        if(node == null){
            if (level != maxLevel){
                if (!isDecreased && level == maxLevel-1){
                    maxLevel--;
                    isDecreased = true;
                    return true;
                }
                return false;
            }
            return true;
        }
        return checkBalance(node.left, level+1) && checkBalance(node.right, level+1);
    }

    public boolean isCompleteTree(TreeNode root) {
        maxLevel = 0;
        isDecreased = false;
        TreeNode curr = root;
        while (curr != null) {
            curr = curr.left;
            maxLevel++;
        }
        return checkBalance(root, 0);
    }
}
