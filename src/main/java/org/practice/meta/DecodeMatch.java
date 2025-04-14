package org.practice.meta;

public class DecodeMatch {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for (int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if (c == '0'){
                dp[i] = 0;
                continue;
            }
            int total = dp[i+1];
            if (i<s.length()-1 && (c == '1' || (c=='2' && s.charAt(i+1) <'7'))){
                total += dp[i+2];
            }
            dp[i] = total;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "25";
        System.out.println(new DecodeMatch().numDecodings(s));
    }
}
