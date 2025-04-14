package org.practice.meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipTree {

    private int getVal(TreeNode node){
        return node != null ? node.val : -1;
    }
    private boolean isEqui(TreeNode node1, TreeNode node2){
        return (getVal(node1.left) == getVal(node2.left)) &&
                (getVal(node1.right) == getVal(node2.right));
    }

    private boolean isFlipEqui(TreeNode node1, TreeNode node2){
        return (getVal(node1.left) == getVal(node2.right)) &&
                (getVal(node1.right) == getVal(node2.left));
    }

    private boolean checkFlip(List<TreeNode> oneList, List<TreeNode> twoList){
        if (oneList.size() != twoList.size()){
            return false;
        }
        else if (oneList.isEmpty()){
            return true;
        }
        List<TreeNode> nextOneList = new ArrayList<>();
        List<TreeNode> nextTwoList = new ArrayList<>();
        for (int i=0; i<oneList.size(); i++){
            TreeNode node1 = oneList.get(i);
            TreeNode node2 = twoList.get(i);
            if (isEqui(node1, node2)){
                if (node1.left != null){
                    nextOneList.add(node1.left);
                    nextTwoList.add(node2.left);
                }
                if (node1.right != null){
                    nextOneList.add(node1.right);
                    nextTwoList.add(node2.right);
                }
            } else if (isFlipEqui(node1, node2)) {
                if (node1.left != null){
                    nextOneList.add(node1.left);
                    nextTwoList.add(node2.right);
                }
                if (node1.right != null){
                    nextOneList.add(node1.right);
                    nextTwoList.add(node2.left);
                }
            }
            else {
                return false;
            }
        }
        return checkFlip(nextOneList, nextTwoList);
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return true;
        } else if (getVal(root1) != getVal(root2)) {
            return false;
        }
        List<TreeNode> oneList = Collections.singletonList(root1);
        List<TreeNode> twoList = Collections.singletonList(root2);
        return checkFlip(oneList, twoList);
    }
}
