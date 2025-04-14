package org.practice.meta;

public class MaxOr {


    public int countMaxOrSubsets(int[] nums) {
        int maxR = 0;
        for (int n : nums){
            maxR = maxR | n;
        }

        int[] counts = new int[maxR+1];
        counts[0] = 1;
        for (int n : nums){
            for (int i=0; i<counts.length; i++){
                if (counts[i] == 0){
                    continue;
                }
                counts[i|n] += counts[i];
            }
        }
        return counts[maxR];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5};
        System.out.println(new MaxOr().countMaxOrSubsets(nums));
    }
}
