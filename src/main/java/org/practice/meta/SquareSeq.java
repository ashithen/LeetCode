package org.practice.meta;

import java.util.HashMap;
import java.util.Map;

public class SquareSeq {

    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> nMap = new HashMap<>();
        int ans = 0;
        for (int n : nums){
            int count = 1;
            int sq = n*n;
            if (nMap.containsKey(n)){
                count = nMap.get(n)+1;
            }
            if (nMap.containsKey(sq)){
                count = Math.max(count, nMap.get(sq)+1);
            }
            nMap.put(sq, count);
            ans = Math.max(ans,count);

        }
        return ans == 1 ? -1 : ans;
    }
}
