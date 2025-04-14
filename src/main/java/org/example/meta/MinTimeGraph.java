package org.example.meta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinTimeGraph {

    int m;
    int n;

    private boolean isValid(int r, int c){
        return (r >= 0 && r < m && c >= 0 && c < n);
    }

    public int minimumTime(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (grid[0][1] > 1 && grid[1][0] > 1){
            return -1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        pq.add(new int[]{0, 0, 0});
        int[][] timeArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(timeArr[i], Integer.MAX_VALUE);
        }
        timeArr[0][0] = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[2] > timeArr[curr[0]][curr[1]]){
                continue;
            }
            if (curr[0] == m-1 && curr[1] == n-1) {
                return curr[2];
            }
            for (int[] dir : dirs) {
                int nR = curr[0] + dir[0];
                int nC = curr[1] + dir[1];
                if (!isValid(nR, nC)) {
                    continue;
                }
                int newCost = curr[2]+1;
                if (grid[nR][nC] > newCost) {
                    newCost = grid[nR][nC] + ((grid[nR][nC] - newCost)&1);
                }
                if (newCost < timeArr[nR][nC]) {
                    pq.add(new int[]{nR, nC, newCost});
                    timeArr[nR][nC] = newCost;
                }
            }
        }
        return -1;
    }
}
