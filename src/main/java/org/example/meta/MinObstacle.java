package org.example.meta;

import java.util.ArrayList;
import java.util.List;

public class MinObstacle {
    int m;
    int n;
    boolean[][] visited;
    int[][] grid;

    private boolean addNext(int r, int c, List<int[]> cList, List<int[]> nList) {
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c]) {
            return false;
        }
        if (r == m - 1 && c == n - 1) {
            return true;
        }
        if (grid[r][c] == 0) {
            cList.add(new int[]{r, c});
        } else {
            nList.add(new int[]{r, c});
        }
        return false;
    }

    public int minimumObstacles(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        m = grid.length;
        n = grid[0].length;

        List<int[]> cList = new ArrayList<int[]>();
        int step = 0;
        cList.add(new int[]{0, 0});

        while (!cList.isEmpty()) {
            List<int[]> nList = new ArrayList<>();
            for (int i = 0; i < cList.size(); i++) {
                int[] cur = cList.get(i);
                if (visited[cur[0]][cur[1]]) {
                    continue;
                }
                visited[cur[0]][cur[1]] = true;
                if (addNext(cur[0] - 1, cur[1], cList, nList ) || addNext(cur[0] + 1, cur[1], cList, nList)
                        || addNext(cur[0],cur[1]-1, cList, nList) || addNext(cur[0], cur[1]+1, cList, nList)) {
                    return step;
                }
            }
            step++;
            cList = nList;
        }

        return m*n-2;
    }
}
