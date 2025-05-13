package org.practice.daily_challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_3341 {

    private int[][] nps = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
        pq.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[rows][cols];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int ct = curr[2];
            if (visited[i][j]) {
                continue;
            }
            if (i == rows - 1 && j == cols - 1) {
                return ct;
            }
            visited[i][j] = true;
            for (int[] np : nps) {
                int ni = i + np[0];
                int nj = j + np[1];
                if (ni < 0 || ni == rows || nj < 0 || nj == cols || visited[ni][nj]) {
                    continue;
                }
                int nt = Math.max(ct, moveTime[ni][nj]) + 1;
                pq.add(new int[]{ni, nj, nt});

            }
        }
        return -1;
    }
}
