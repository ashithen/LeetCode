package org.example.meta;

import java.util.Arrays;

public class ValidPalin3 {
    public boolean isValidPalindrome(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        dp[0] = k;
        for (int j=s.length()-1; j>=0; j--){
            for (int i=0; i<s.length(); i++){
                return true;
            }
        }
        return true;
    }
}
