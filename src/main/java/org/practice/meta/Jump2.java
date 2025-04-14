package org.practice.meta;

public class Jump2 {

    public int jump(int[] nums) {
        int pMax = -1;
        int cMax = 0;
        int nMax = 0;
        int step = 0;
        while (true){
            for (int i=pMax+1; i<=cMax; i++){
                nMax = Math.max(nMax,i+nums[i]);
            }
            if (nMax >= nums.length-1){
                return step+1;
            }
            step++;
            pMax = cMax;
            cMax = nMax;
        }
    }
}
