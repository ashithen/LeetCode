package org.practice.meta;

public class SubArrayCount {
    public int subarraySum(int[] nums, int k) {
        int minN = 0;
        int maxN = 0;
        int sum = 0;
        for (int n : nums){
            sum += n;
            minN = Math.min(minN,sum);
            maxN = Math.max(maxN, sum);
        }
        if (k < minN || k > maxN){
            return 0;
        }
        int[] counts = new int[maxN-minN+1];
        sum = -minN;
        for (int n : nums){
            sum += n;
            counts[sum]++;
        }
        sum = -minN;
        int result = counts[k+sum];
        for (int n : nums){
            sum += n;
            counts[sum]--;
            result += counts[k+sum];
        }
        return result;
    }
}
