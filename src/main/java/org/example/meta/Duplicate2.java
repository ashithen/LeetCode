package org.example.meta;

import java.util.HashSet;
import java.util.Set;

public class Duplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        for (int i=0; i<Math.min(nums.length, k+1);i++){
            numSet.add(nums[i]);
            if (numSet.size() != i+1){
                return true;
            }
        }
        int j=0;
        for (int i=k+1; i<nums.length; i++){
            numSet.remove(nums[j]);
            j++;
            numSet.add(nums[i]);
            if (numSet.size() != k+1){
                return true;
            }
        }
        return false;
    }
}
