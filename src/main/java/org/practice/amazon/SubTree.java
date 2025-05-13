package org.practice.amazon;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SubTree {

    private String subTreeCode;
    private void encode(TreeNode node,StringBuilder sb) {
        if (node == null){
            sb.append("_,");
            return;
        }
        this.encode(node.left, sb);
        this.encode(node.right, sb);
        sb.append(node.val).append(",");
    }

    private boolean isFound(TreeNode node,StringBuilder sb){
        if (node == null){
            sb.append("_,");
            return false;
        }
        StringBuilder lsb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();
        if (this.isFound(node.left, lsb) || this.isFound(node.right, rsb)){
            return true;
        };
        sb.append(lsb).append(rsb).append(node.val).append(",");
        return subTreeCode.contentEquals(sb);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sb = new StringBuilder("");
        this.encode(subRoot,sb);
        subTreeCode = sb.toString();
        return isFound(root,new StringBuilder());
    }
}
