package org.practice.meta;

import java.util.Arrays;

public class LongIncreasingPath {

    int[][] matrix;
    int[][] cache;

    private int getMaxPathCount(int row, int col){
        if (this.cache[row][col] != -1){
            return this.cache[row][col];
        }

        int maxPath = 0;
        if (row > 0 && this.matrix[row-1][col] > this.matrix[row][col]){
            maxPath = Math.max(maxPath, this.getMaxPathCount(row-1,col));
        }
        if (col > 0 && this.matrix[row][col-1] > this.matrix[row][col]){
            maxPath = Math.max(maxPath, this.getMaxPathCount(row, col-1));
        }
        if (row < this.matrix.length-1 && this.matrix[row+1][col] > this.matrix[row][col]){
            maxPath = Math.max(maxPath, this.getMaxPathCount(row+1, col));
        }
        if (col < this.matrix[0].length-1 && this.matrix[row][col+1] > this.matrix[row][col]){
            maxPath = Math.max(maxPath, this.getMaxPathCount(row, col+1));
        }

        maxPath++;
        this.cache[row][col] = maxPath;
        return maxPath;
    }
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.cache = new int[matrix.length][matrix[0].length];

        for (int i=0; i< matrix.length; i++){
            Arrays.fill(cache[i],-1);
        }

        int res = 0;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                res = Math.max(res, this.getMaxPathCount(i,j));
            }
        }
        return res;

    }
}
