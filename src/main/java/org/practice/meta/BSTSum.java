package org.practice.meta;

public class BSTSum {

    private int low;
    private int high;

    private int getSum(TreeNode node){
        if (node == null){
            return 0;
        }
        else if (node.val >= this.low && node.val <= this.high){
            return node.val + this.getSum(node.right) + this.getSum(node.left);
        }
        else if (node.val < this.high){
            return this.getSum(node.right);
        }
        else  {
            return this.getSum(node.left);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        return this.getSum(root);
    }
}
