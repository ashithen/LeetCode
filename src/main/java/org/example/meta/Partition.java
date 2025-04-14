package org.example.meta;

public class Partition {

    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num : nums){
            sum+=num;
        }
        if (sum%2!=0){
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0]=true;
        for (int num : nums){
            for (int i=target-num; i>=0; i--){
                if (dp[i]){
                    int m = i+num;
                    if (m == target){
                        return true;
                    }
                    else {
                        dp[m] = true;
                    }
                }
            }
        }
        return false;
    }
}
