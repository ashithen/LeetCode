package org.practice.meta;

public class MaxXor {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] ans = new int[nums.length];
        int m = (int) (Math.pow(2,maximumBit)-1);
        for (int n : nums){
            m ^= n;
        }
        ans[0] = m;
        for (int i=1; i< nums.length; i++){
            ans[i] = ans[i-1]^nums[nums.length-i];
        }
        return ans;
    }
}
