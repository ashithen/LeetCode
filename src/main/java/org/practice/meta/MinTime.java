package org.practice.meta;

import java.util.*;

public class MinTime {

    private int[][] grid;
    private int n;

    private boolean isValidIndex(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    private boolean addToQueue(int r, int c, int maxDepth, Set<Integer> visited, Queue<int[]> queue) {
        if (r == n - 1 && c == n - 1) {
            return true;
        }
        if (isValidIndex(r, c) && !visited.contains(grid[r][c]) && grid[r][c] <= maxDepth) {
            visited.add(grid[r][c]);
            queue.add(new int[]{r, c});
        }
        return false;
    }

    private boolean canSwim(int maxDepth) {
        if (grid[0][0] > maxDepth || grid[n - 1][n - 1] > maxDepth) {
            return false;
        }
        Set<Integer> visited = new HashSet<Integer>();
        Queue<int[]> queue = new LinkedList<int[]>();
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (addToQueue(curr[0] - 1, curr[1], maxDepth, visited, queue) ||
                    addToQueue(curr[0] + 1, curr[1], maxDepth, visited, queue) ||
                    addToQueue(curr[0], curr[1] - 1, maxDepth, visited, queue) ||
                    addToQueue(curr[0], curr[1] + 1, maxDepth, visited, queue)) {
                return true;
            }
        }
        return false;
    }

    public int swimInWater(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        int[] allValues = new int[n * n];
        int k=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                allValues[k++] = grid[i][j];
            }
        }
        Arrays.sort(allValues);
        int low = 0;
        int high = n - 1;
        int res = allValues[high];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canSwim(allValues[mid])) {
                res = allValues[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return res;
    }
}
