package org.practice.daily_challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

class State {
    int ri;
    int cj;
    int time;
    int nextTime;

    public State(int ri, int cj, int time, int nextTime) {
        this.ri = ri;
        this.cj = cj;
        this.time = time;
        this.nextTime = nextTime;
    }
}

public class LC_3342 {
    private int[][] nps = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt((State e) -> e.time)
                .thenComparing(e -> e.nextTime));
        pq.add(new State(0,0,0,1));
        boolean[][] visited = new boolean[rows][cols];
        while (!pq.isEmpty()) {
            State cState = pq.poll();
            if (visited[cState.ri][cState.cj]) {
                continue;
            }
            if (cState.ri == rows - 1 && cState.cj == cols - 1) {
                return cState.time;
            }
            visited[cState.ri][cState.cj] = true;
            for (int[] np : nps) {
                int ni = cState.ri + np[0];
                int nj = cState.cj + np[1];
                if (ni < 0 || ni == rows || nj < 0 || nj == cols || visited[ni][nj]) {
                    continue;
                }
                int nt = Math.max(cState.time, moveTime[ni][nj]) + cState.nextTime;
                pq.add(new State(ni,nj,nt,cState.nextTime==1 ? 2 : 1));
            }
        }
        return -1;
    }
}
