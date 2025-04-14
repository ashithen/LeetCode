package org.example.meta;

import java.util.*;

public class LevelK {

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        while (!curr.isEmpty()){
            long sum = 0;
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode t : curr){
                if (t.left != null){
                    next.add(t.left);
                }
                if (t.right != null){
                    next.add(t.right);
                }
                sum += t.val;
            }
            if (pq.size() == k && sum > pq.peek()) {
                pq.poll();
            }
            if (pq.size() < k) {
                pq.add(sum);
            }
            curr = next;
        }
        return pq.size() == k ? pq.peek() : -1;
    }
}
