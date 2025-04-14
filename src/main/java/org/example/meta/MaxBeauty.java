package org.example.meta;

import java.util.Arrays;
import java.util.Comparator;

public class MaxBeauty {

    private int getMax(int[][] items, int target){
        int low = 0;
        int high = items.length-1;
        int res = items[0][1];
        while (low <= high){
            int mid = (low+high)/2;
            if (items[mid][0] <= target){
                res = items[mid][1];
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return res;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a->a[0]));
        int maxB = items[0][1];
        for (int i=1; i<items.length; i++){
            maxB = Math.max(maxB, items[i][1]);
            items[i][1] = maxB;
        }
        int[] output = new int[queries.length];
        for (int i=0; i< queries.length; i++){
            output[i] = this.getMax(items, queries[i]);
        }
        return output;
    }
}
