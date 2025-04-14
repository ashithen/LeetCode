package org.practice.meta;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RobotDis {
    private List<Integer> robot;
    int[][] factory;
    long[][] cache;

    private long getMinDis(int rIndex, int fIndex, int limitLeft){
        if (rIndex == robot.size()){
            return 0;
        }
        if (fIndex == factory.length || this.robot.size()-rIndex > limitLeft){
            return Long.MAX_VALUE;
        }
        if (this.cache[rIndex][fIndex] != -1){
            return this.cache[rIndex][fIndex];
        }
        long minDist = this.getMinDis(rIndex,fIndex+1,limitLeft-factory[fIndex][1]);
        long cDist = 0;
        int cLimit = this.factory[fIndex][1];
        int crI = rIndex;
        while (cLimit > 0 && crI< robot.size()){
            cDist += Math.abs(factory[fIndex][0]-robot.get(crI));
            crI++;
            cLimit--;
            long nextDist = this.getMinDis(crI,fIndex+1,limitLeft-factory[fIndex][1]);
            if (nextDist != Long.MAX_VALUE){
                minDist = Math.min(minDist, cDist+nextDist);
            }
        }
        this.cache[rIndex][fIndex] = minDist;
        return minDist;
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a->a[0]));
        this.robot = robot;
        this.factory = factory;
        this.cache = new long[robot.size()][factory.length];
        for (long[] cr : cache){
            Arrays.fill(cr,-1);
        }
        int limitLeft = 0;
        for (int[] f : factory){
            limitLeft += f[1];
        }
        return this.getMinDis(0,0,limitLeft);
    }
}
