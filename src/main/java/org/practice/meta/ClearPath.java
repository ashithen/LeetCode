package org.practice.meta;

import java.util.Arrays;

public class ClearPath {


    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        int MAX = n*n+2;
        int[][] counts = new int[grid.length][grid[0].length];
        for (int i=0; i<n; i++){
            Arrays.fill(counts[i],MAX);
        }
        counts[0][0] = 1;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == 1){
                    continue;
                }
                for (int p=i-1; p<=i+1; p++){
                    for (int q=j-1; q<=j+1; q++){
                        if ((p==i && q==j) || p<0 || p==n || q<0 || q==n || grid[p][q] == 1){
                            continue;
                        }
                        counts[p][q] = Math.min(counts[p][q], counts[i][j]+1);
                    }
                }
            }
        }
        return counts[n-1][n-1] < MAX ? counts[n-1][n-1] : -1;
    }
}
