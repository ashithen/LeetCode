package org.example.meta;

import java.util.ArrayList;
import java.util.List;

public class KDistTree {

    List<Integer> output;
    TreeNode target;
    int k;

    private void addNodes(TreeNode node, int dist){
        if (node == null){
            return;
        }
        if (dist == k){
            output.add(node.val);
            return;
        }
        addNodes(node.left, dist+1);
        addNodes(node.right, dist+1);
    }

    private int traverse(TreeNode node){
        if (node == null){
            return -1;
        }
        if (node == target){
            addNodes(target,0);
            return 1;
        }
        int dTravel = this.traverse(node.left);
        TreeNode addChild = node.right;
        if (dTravel == -1){
            addChild = node.left;
            dTravel = this.traverse(node.right);
        }
        if (dTravel == -1 || dTravel > k){
            return dTravel == -1 ? -1 : dTravel+1;
        }
        if (dTravel == k){
            addNodes(node,dTravel);
        } else {
            addNodes(addChild, dTravel);
        }
        return dTravel+1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.output = new ArrayList<>();
        this.k = k;
        this.target = target;
        this.traverse(root);
        return output;
    }
}
