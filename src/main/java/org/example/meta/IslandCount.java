package org.example.meta;

import java.util.LinkedList;
import java.util.Queue;

public class IslandCount {

    private void traverse(char[][] grid, Queue<int[]> queue, int m, int n) {
        if(!(m < 0 || n < 0 || m == grid.length || n == grid[0].length || grid[m][n] == '0')){
            grid[m][n] = '0';
            queue.add(new int[]{m,n});
        }
    }

    public int numIslands(char[][] grid) {

        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                grid[i][j] = '0';
                islandCount++;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] p = queue.poll();
                    traverse(grid, queue, p[0]-1,p[1]);
                    traverse(grid, queue, p[0]+1, p[1]);
                    traverse(grid, queue, p[0], p[1]-1);
                    traverse(grid, queue,p[0],p[1]+1);
                }
            }
        }
        return islandCount;
    }
}
