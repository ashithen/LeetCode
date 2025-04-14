package org.example.meta;

import java.util.*;

public class OceanView {

    public int[] findBuildings(int[] heights) {
        List<Integer> vBuilds = new ArrayList<>();
        int maxB = 0;
        for (int i=heights.length-1; i>=0; i--){
            if (heights[i] > maxB){
                maxB = heights[i];
                vBuilds.add(i);
            }
        }
        Collections.reverse(vBuilds);
        return vBuilds.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }

}
