package org.practice.meta;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class CustomBTree {
    private Map<Integer,Integer> levelSumMap;

    private void traverse(TreeNode node, int level){
        if (node == null){
            return;
        }
        this.levelSumMap.put(level,this.levelSumMap.getOrDefault(level,0)+node.val);
        this.traverse(node.left,level+1);
        this.traverse(node.right,level+1);
    }

    private void replaceVal(TreeNode node, int level, int nextVal){
        if (node == null){
            return;
        }
        node.val = nextVal;
        if (!this.levelSumMap.containsKey(level+1)){
            return;
        }
        int nextSum = this.levelSumMap.get(level+1);
        nextSum -= node.left != null ? node.left.val : 0;
        nextSum -= node.right != null ? node.right.val : 0;
        this.replaceVal(node.left, level+1, nextSum);
        this.replaceVal(node.right, level+1, nextSum);
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        this.levelSumMap = new HashMap<>();
        this.traverse(root, 0);
        this.replaceVal(root,0,0);
        return root;
    }


    public static void main(String[] args) {
        int m = 10;
        Instant sTime = Instant.now();
        int steps = 100_000_000;
        for (int i=0; i<steps;i++){
            m++;
        }
        Instant eTime = Instant.now();
        System.out.println(Duration.between(sTime, eTime).toMillis());

        Integer kk = (Integer) 10;
        Instant sTime2 = Instant.now();
        for (int i=0; i<steps;i++){
            kk++;
        }
        Instant eTime2 = Instant.now();
        System.out.println(Duration.between(sTime2, eTime2).toMillis());
    }
}
