package org.practice.meta;

public class BitWiseAnd {

    public int largestCombination(int[] candidates) {
        int[] counts = new int[32];
        int maxC = 0;
        for (int cd : candidates){
            for (int i=0; i<32; i++){
                int n = 1 << i;
                if (n > cd){
                    break;
                }
                if ((n&cd) > 0){
                    counts[i]++;
                    maxC = Math.max(maxC, counts[i]);
                }
            }
        }
        return maxC;
    }
}
