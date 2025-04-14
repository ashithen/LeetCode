package org.example.meta;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int lowest = 0;
        for (int num : nums){
            lowest -= num;
        }
        int[] countArr = new int[2*(-lowest)+1];
        countArr[0] = 1;
        if (target == lowest){
            return 1;
        }
        for (int i=0; i<countArr.length; i++){
            int sum=0;
            for (int j=i; j<nums.length; j++){
                sum += nums[j];
                countArr[lowest+2*sum]++;
            }
        }
        return countArr[target];
    }
}
