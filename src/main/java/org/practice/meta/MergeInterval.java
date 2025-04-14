package org.practice.meta;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {

    private int getMaxIndex(int[][] intervals){
        int max=0;
        for (int[] in : intervals){
            for (int n : in){
                max = Math.max(max,n);
            }
        }
        return max;
    }
    public int[][] merge(int[][] intervals) {
        int maxIndex = this.getMaxIndex(intervals);
        int[] sCount = new int[maxIndex+1];
        int[] eCount = new int[maxIndex+1];

        for (int[] ints : intervals){
            sCount[ints[0]]++;
            eCount[ints[1]]++;
        }

        List<int[]> result = new ArrayList<>();
        int start = -1;
        int sum = 0;
        for (int i=0; i<=maxIndex; i++){
            if (sCount[i] == 0 && eCount[i] == 0){
                continue;
            }
            sum += sCount[i];
            if (sum == sCount[i]){
                start = i;
            }
            sum -= eCount[i];
            if (sum == 0){
                result.add(new int[]{start, i});
            }
        }
        int[][] resArray = new int[result.size()][2];
        return result.toArray(resArray);
    }
}
