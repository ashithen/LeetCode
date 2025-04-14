package org.practice.meta;

public class CommonParent {

    private TreeNode p;
    private TreeNode q;
    private TreeNode parent;

    private boolean[] findPQ(TreeNode node){
        if(node == null){
            return new boolean[]{false,false};
        }
        boolean[] lRes = findPQ(node.left);
        boolean[] rRes = findPQ(node.right);
        boolean pFound = node.val == p.val || lRes[0] || rRes[0];
        boolean qFound = node.val == q.val || lRes[1] || rRes[1];
        if (pFound && qFound){
            parent = node;
        }
        return new boolean[]{pFound,qFound};
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        this.parent = null;
        findPQ(root);
        return this.parent;
    }
}
