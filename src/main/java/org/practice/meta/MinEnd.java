package org.practice.meta;

import java.util.HashSet;
import java.util.Set;

public class MinEnd {

    private Set<Integer> getPos(int num){
        int k=1;
        int c = 0;
        Set<Integer> posSet = new HashSet<>();
        while (k<=num){
            if ((k&num) > 0){
                posSet.add(c);
            }
            c++;
            k <<= 1;
        }
        return posSet;
    }

    public long minEnd(int n, int x) {
        Set<Integer> posSet = getPos(n-1);
        int k=1;
        int c=0;
        int ans = x;
        while (!posSet.isEmpty()){
            if ((k&ans) == 0 && posSet.contains(c)){
                ans ^= k;
                posSet.remove(c);
            }
            k <<= 1;
            c++;
        }
        return ans;
    }
}
