package org.example.meta;

public class BuildTree {

    private int index;
    private String s;

    private TreeNode buildTree(){
        if (index == s.length()){
            return null;
        }
        int num = 0;
        boolean isNegative = false;
        while (index < s.length()){
            if (s.charAt(index) == '-'){
                isNegative = true;
            } else if (Character.isDigit(s.charAt(index))) {
                num *= 10;
                num += Character.digit(s.charAt(index),10);
            }
            else {
                break;
            }
            index++;
        }
        if (isNegative){
            num *= -1;
        }
        TreeNode newNode = new TreeNode(num);
        while (index < s.length() && s.charAt(index) == '('){
            index++;
            if (newNode.left == null){
                newNode.left = buildTree();
            }
            else {
                newNode.right = buildTree();
            }
        }
        index++;
        return newNode;
    }

    public TreeNode str2tree(String s) {
        this.s = s;
        this.index = 0;
        return buildTree();
    }
}
