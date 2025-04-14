package org.example.meta;

public class MaximumOne {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int curr = k;
        int ones = 0;
        int maxOnes = 0;

        while (i<nums.length) {
            if (curr > 0 || nums[i] == 1) {
                if (nums[i] == 0) {
                    curr--;
                }
                i++;
                ones++;
                maxOnes = Math.max(maxOnes, ones);
            } else if (j < i) {
                if (nums[j] == 0) {
                    curr++;
                }
                j++;
                ones--;
            } else {
                j++;
                i++;
            }
        }
        return maxOnes;
    }
}
