package org.example.meta;

import java.util.*;

public class LargeIsland {
    private int[][] grid;
    int n;
    private boolean[][] visited;
    private Map<Integer, Integer> sizeMap;


    private void visit(int r, int c, List<int[]> path) {
        if (r < 0 || r == n || c < 0 || c == n
                || grid[r][c] == 0 || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        path.add(new int[]{r,c});
        visit(r - 1, c, path);
        visit(r + 1, c, path);
        visit(r, c - 1, path);
        visit(r, c + 1, path);
    }

    private int addSize(int r, int c, Set<Integer> uniqueIsland){
        if (r < 0 || c < 0 || r == n || c == n){
            return 0;
        }
        int cIsland = grid[r][c];
        if (uniqueIsland.contains(cIsland)){
            return 0;
        }
        uniqueIsland.add(cIsland);
        return sizeMap.get(cIsland);
    }

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        visited = new boolean[n][n];
        sizeMap = new HashMap<>();
        int islandId = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                List<int[]> path = new ArrayList<>();
                this.visit(i,j, path);
                for (int[] point : path) {
                    grid[point[0]][point[1]] = islandId;
                }
                sizeMap.put(islandId, path.size());
                islandId++;
            }
        }

        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    continue;
                }
                Set<Integer> uniqueIslands = new HashSet<>();
                int size = 1;
                size += addSize(i-1,j,uniqueIslands);
                size += addSize(i+1, j, uniqueIslands);
                size += addSize(i,j-1, uniqueIslands);
                size += addSize(i, j+1, uniqueIslands);
                maxSize = Math.max(maxSize, size);
            }
        }
        return maxSize;
    }
}


