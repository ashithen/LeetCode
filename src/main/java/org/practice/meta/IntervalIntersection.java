package org.practice.meta;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            if (!((firstList[i][1] < secondList[j][0]) ||(firstList[i][0] > secondList[j][1]))) {
                int start = Math.max(firstList[i][0], secondList[j][0]);
                int end = Math.min(firstList[i][1], secondList[j][1]);
                result.add(new int[]{start, end});
            }
            if (firstList[i][1] == secondList[j][1]) {
                i++;
                j++;
            } else if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] resArray = new int[result.size()][2];
        return result.toArray(resArray);
    }
}
