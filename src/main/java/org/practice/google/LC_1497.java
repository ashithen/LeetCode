package org.practice.google;

public class LC_1497 {
    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k+1];
        for(int i: arr) {
            count[Math.floorMod(i,k)]++;
        }
        if(count[0]%2!=0) {
            return false;
        }
        for(int i=1; i<=k/2; i++) {
            if(count[i]!=count[k-i]) return false;
        }
        return true;
    }
}
