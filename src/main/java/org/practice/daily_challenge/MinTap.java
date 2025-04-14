package org.practice.daily_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinTap {

    public int minTaps(int n, int[] ranges) {
        List<TapRange> tapRanges = new ArrayList<>();
        for(int i=0; i < ranges.length; i++){
            if (ranges[i] == 0){
                continue;
            }
            tapRanges.add(new TapRange(i-ranges[i],i+ranges[i],i));
        }
        Collections.sort(tapRanges);
        for (TapRange tp : tapRanges){
            System.out.println(tp);
        }

        int curr = 0;
        int i = 0;
        int totalTap = 0;
        while (curr <= n){
            int nextMax = curr;
            while (i < tapRanges.size() && tapRanges.get(i).getLeft() <= curr ){
                nextMax = Math.max(nextMax, tapRanges.get(i).getRight());
                i += 1;
            }
            if (nextMax == curr){
                return -1;
            } else if (nextMax >= n) {
                System.out.printf("Selected index: %d range: %d\n",tapRanges.get(i-1).getIndex(), ranges[tapRanges.get(i-1).getIndex()]);
                return totalTap + 1;
            }
            else {
                System.out.printf("Selected index: %d range: %d\n",tapRanges.get(i-1).getIndex(), ranges[tapRanges.get(i-1).getIndex()]);
                totalTap += 1;
                curr = nextMax;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        MinTap minTap = new MinTap();
        int n = 35;
        int[] ranges = {1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2};
        System.out.println(minTap.minTaps(n, ranges));
    }
}
