package org.practice.meta;

import java.util.Arrays;
import java.util.Comparator;

public class TwoVal {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));
        int[] maxRewards = new int[events.length];
        int maxVal = 0;
        for(int i=events.length-1; i>=0; i--) {
            maxVal = Math.max(maxVal, events[i][2]);
            maxRewards[i] = maxVal;
        }
        int output = 0;
        for (int i=0; i<events.length; i++) {
            int left = i+1;
            int right = events.length-1;
            int res = -1;
            while (left <= right) {
                int mid = (left+right)/2;
                if (events[mid][0] > events[i][1]) {
                    res = mid;
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            int cVal = events[i][2] + (res == -1 ? 0 : maxRewards[res]);
            output = Math.max(output, cVal);
        }
        return output;
    }
}
