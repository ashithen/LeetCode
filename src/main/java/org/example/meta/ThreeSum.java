package org.example.meta;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultSet = new ArrayList<>();

        for (int i=0; i<nums.length-2; i++){
            if (nums[i] > 0){
                break;
            }
            if (i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int j=i+1;
            int k = nums.length-1;
            while (j<k){
                if (nums[j]+nums[k] == target){
                    resultSet.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++; k--;
                }
                else if (nums[j]+nums[k] < target){
                    j++;
                    while (j<k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
                else {
                    k--;
                }
            }
        }
        return resultSet;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        new ThreeSum().threeSum(nums);
    }
}


