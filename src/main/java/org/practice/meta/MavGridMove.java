package org.practice.meta;

import java.util.Arrays;

public class MavGridMove {

    int[][] cache;
    int[][] grid;

    private int getMaxMove(int row, int col){
        if (col == grid[0].length-1){
            return 1;
        }
        if (this.cache[row][col] != -1) {
            return this.cache[row][col];
        }
        int steps = 0;
        for (int i=Math.max(0,row-1); i<=Math.min(grid.length-1, row+1); i++){
            if (this.grid[row][col] < this.grid[i][col+1]) {
                steps = Math.max(steps, this.getMaxMove(i, col + 1));
                if (steps == (grid[0].length - (col + 1))) {
                    break;
                }
            }
        }
        steps++;
        this.cache[row][col] = steps;
        return steps;
    }

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        cache = new int[grid.length][grid[0].length];
        for (int i=0; i< grid.length; i++){
            Arrays.fill(cache[i],-1);
        }
        int res = 0;
        for (int i=0; i<grid.length; i++){
            res = Math.max(res, this.getMaxMove(i,0));
            if(res == this.grid[0].length){
                break;
            }
        }
        res--;
        return res;
    }
}
