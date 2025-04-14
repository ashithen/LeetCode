package org.example.meta;

import java.util.Arrays;

public class Share4 {
    private int[][] cache;
    private int[] prices;

    private int getProfit(int start, int kLeft){
        if (start == prices.length){
            return 0;
        }
        if (this.cache[start][kLeft] != -1){
            return this.cache[start][kLeft];
        }
        int minP = start;
        int maxD = 0;
        for (int i=start; i<prices.length; i++){
            if (prices[i] <= minP){
                minP = prices[i];
            }
            else {
                maxD = Math.max(maxD, prices[i]-minP+this.getProfit(i+1,kLeft-1));
            }
        }
        this.cache[start][kLeft] = maxD;
        return maxD;
    }
    public int maxProfit(int k, int[] prices) {
        this.cache = new int[prices.length][k+1];
        for (int i=0; i<prices.length; i++){
            Arrays.fill(this.cache[i],-1);
        }
        this.prices = prices;
        return this.getProfit(0,k);
    }
}
