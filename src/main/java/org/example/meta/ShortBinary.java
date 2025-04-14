package org.example.meta;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class ShortBinary {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[n-1][n-1] == 1){
            return -1;
        }
        int[][]counts = new int[n][n];
        counts[n-1][n-1] = 1;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(n-1,n-1));

        while (!queue.isEmpty()){
            Pair<Integer, Integer> pair = queue.poll();
            for (int i=-1; i<2; i++){
                for (int j=-1; j<2; j++){
                    int val = counts[pair.getKey()][pair.getValue()];
                    int x = pair.getKey()+i;
                    int y = pair.getValue()+j;
                    if (x>=0 && x<n && y>=0 && y<n && grid[x][y] == 0 && counts[x][y] != 0){
                        counts[x][y] = val+1;
                        queue.add(new Pair<>(x,y));
                    }
                }
            }
        }
        return counts[0][0] < Integer.MAX_VALUE ? counts[0][0] : -1;
    }
}
