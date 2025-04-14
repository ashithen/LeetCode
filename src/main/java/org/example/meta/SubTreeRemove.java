package org.example.meta;

import java.util.HashMap;
import java.util.Map;

class TreeData{
    int lH;
    int rH;
    int height;
    TreeNode parent;
    boolean isLeftChild;

    public TreeData(int lH, int rH, int h, TreeNode parent, boolean isLeftChild){
        this.lH = lH;
        this.rH = rH;
        this.height = h;
        this.parent = parent;
        this.isLeftChild = isLeftChild;
    }
}
public class SubTreeRemove {

    private Map<Integer, TreeData> dataMap;

    private int traverse(TreeNode node, TreeNode parent, boolean isLeftChild){
        if (node == null){
            return 0;
        }
        int lH = this.traverse(node.left, node, true);
        int rH = this.traverse(node.right, node, false);
        dataMap.put(node.val, new TreeData(lH, rH, Math.max(lH, rH), parent, isLeftChild));
        return Math.max(lH,rH)+1;
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        this.dataMap = new HashMap<>();
        this.traverse(root, null, false);
        int[] result = new int[queries.length];

        for (int i=0; i< queries.length; i++){
            int q = queries[i];
            TreeData nData = this.dataMap.get(q);
            int newHeight = 0;
            boolean isChanged = true;

            while (isChanged && nData.parent != null){
                TreeData cData = this.dataMap.get(nData.parent.val);
                int lH = nData.isLeftChild ? newHeight : cData.lH;
                int rH = !nData.isLeftChild ? newHeight : cData.rH;
                newHeight = Math.max(lH,rH);
                isChanged = newHeight != cData.height;
                nData = cData;
            }
            result[i] = nData.parent == null ? newHeight : root.val;
        }
        return result;
    }
}
