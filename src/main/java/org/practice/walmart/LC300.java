package org.practice.walmart;

import java.util.SortedMap;
import java.util.TreeMap;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int ans = 0;
        for(int n : nums){
            SortedMap<Integer, Integer> sMap = treeMap.headMap(n);
            int pMax = treeMap.headMap(n).values().stream().mapToInt(Integer::intValue).max().orElse(0);
            ans = Math.max(ans, pMax+1);
            treeMap.put(n, pMax+1);
        }
        return ans;
    }
}
