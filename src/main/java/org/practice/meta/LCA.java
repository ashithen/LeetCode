package org.practice.meta;

public class LCA {

    private TreeNode ans;
    private int traverse(TreeNode node, TreeNode p, TreeNode q){
        if (node == null){
            return 0;
        }
        int res = 0;
        if(node == p || node == q){
            res++;
        }
        if (this.traverse(node.left, p, q) > 0){
            res++;
        }
        if (this.traverse(node.right, p, q)>0){
            res++;
        }
        if (res >= 2){
            this.ans = node;
        }
        return res > 0 ? 1 : 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
        this.traverse(root, p, q);
        return this.ans;
    }
}
