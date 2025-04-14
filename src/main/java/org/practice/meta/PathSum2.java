package org.practice.meta;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    private List<List<Integer>> result;
    private int target;

    private boolean traverse(TreeNode node, List<Integer> path, int cSum){
        if (node == null){
            return false;
        }
        path.add(node.val);
        cSum += node.val;
        boolean leftR = this.traverse(node.left, path, cSum);
        if (leftR) {
            cSum -= path.remove(path.size() - 1);
        }
        boolean rightR = this.traverse(node.right,path,cSum);
        if (rightR){
            cSum -= path.remove(path.size()-1);
        }
        if (!leftR && !rightR && cSum == this.target){
            result.add(new ArrayList<>(path));
        }
        return true;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        this.target = targetSum;
        this.traverse(root, new ArrayList<>(), 0);
        return this.result;
    }
}
