package org.example.meta;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortSubArray {
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[0]));
        int sum = 0;
        int shortL = Integer.MAX_VALUE;
        int zIndex = -1;
        for (int i=0; i< nums.length; i++){
            sum += nums[i];
            if (sum <= 0){
                pq.clear();
                zIndex = i;
                sum=0;
                continue;
            }
            if (sum >= k){
                shortL = Math.min(shortL, i-zIndex);
                while (!pq.isEmpty() && (sum-pq.peek()[0]) >= k){
                    shortL = Math.min(shortL, i-pq.poll()[1]);
                }
            }
            pq.add(new int[]{sum,i});
        }
        return shortL != Integer.MAX_VALUE ? shortL : -1;
    }
}
