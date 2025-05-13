package org.practice.daily_challenge;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class LC_3335 {

    private int MOD = 1000000007;
    private int[][] cache;

    private int getCount(int c, int t_left){
        if (cache[c][t_left] > 0){
            return cache[c][t_left];
        }
        int ans;
        if (t_left >= 26-c){
            ans = (getCount(0,t_left-(26-c))+getCount(1,t_left-(26-c)))%MOD;
        }
        else {
            ans = 1;
        }
        cache[c][t_left] = ans;
        return ans;
    }
    public int lengthAfterTransformations(String s, int t) {
        cache = new int[26][t+1];
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans += getCount(c-'a',t);
            ans %= MOD;
        }
        return ans;
    }
}
