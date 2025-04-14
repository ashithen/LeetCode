package org.practice.meta;

public class MinProduct {

    private boolean isPossible(int[] quantities, int n, int d){
        int i=0;
        while (i< quantities.length){
            if (n<=0){
                break;
            }
            int q = quantities[i];
            n -= q/d;
            if (q%d != 0){
                n--;
            }
            i++;
        }
        return n >= 0 && i== quantities.length;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int low = Integer.MAX_VALUE;
        int high = 0;
        for (int q : quantities) {
            low = Math.min(low, q);
            high = Math.max(high, q);
        }
        int res = high;

        while (low <= high){
            int mid = (low+high)/2;
            if (isPossible(quantities, n, mid)){
                high = mid-1;
                res = mid;
            }
            else {
                low = mid+1;
            }
        }
        return res;
    }
}
