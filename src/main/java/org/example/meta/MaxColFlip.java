package org.example.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class MaxColFlip {

    private void addToDict(Map<String, Integer> cMap, String key){
        if (cMap.containsKey(key)){
            cMap.put(key, cMap.get(key) + 1);
        }
        else{
            cMap.put(key, 1);
        }
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> countMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringJoiner zj = new StringJoiner(" ");
            StringJoiner oj = new StringJoiner(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zj.add(Integer.toString(j));
                }
                else {
                    oj.add(Integer.toString(j));
                }
                addToDict(countMap, zj.toString());
                addToDict(countMap, oj.toString());
            }
        }
        int maxCount = 0;
        for (int c : countMap.values()) {
            maxCount = Math.max(maxCount, c);
        }
        return maxCount;
    }
}
