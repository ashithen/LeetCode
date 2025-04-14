package org.practice.meta;

public class ClosestBST {

    public int closestValue(TreeNode root, double target) {
        double closest = root.val;
        TreeNode next = closest > target ? root.left : root.right;
        while (next != null){
            double prev = Math.abs(closest-target);
            double curr = Math.abs(next.val)-target;
            if (prev < curr){
                closest = next.val;
            } else if (prev == curr) {
                closest = Math.min(closest, next.val);
            }

            if (Math.abs(next.val-target) < Math.abs(closest-target)){
                closest = next.val;
            }
            next = next.val > target ? next.left : next.right;
        }
        return (int) closest;
    }
}
