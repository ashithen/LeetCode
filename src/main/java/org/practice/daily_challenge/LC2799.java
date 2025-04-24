package org.practice.daily_challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LC2799 {
    public int countCompleteSubarrays(int[] nums) {
        boolean[] isPresent = new boolean[2001];
        int totalDCount = 0;
        for(int n:nums){
            if (!isPresent[n]) {
                totalDCount++;
                isPresent[n] = true;
            }
        }
        int[] countArray = new int[2001];
        int end=0;
        int start=0;
        int ans=0;
        int dCount=0;
        while (end<nums.length){
            if (countArray[nums[end]]==0){
                dCount++;
            }
            countArray[nums[end]]++;
            while (dCount==totalDCount){
                ans+=nums.length-end;
                countArray[nums[start]]--;
                if (countArray[nums[start]]==0){
                    dCount--;
                }
                start++;
            }
            end++;
        }
        return ans;
    }
}
