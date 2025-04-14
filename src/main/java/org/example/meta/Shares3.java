package org.example.meta;

public class Shares3 {

    public int maxProfit(int[] prices) {
        int[] leftMax = new int[prices.length];
        int minP = prices[0];
        int maxD = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i] < minP){
                minP = prices[i];
            }
            else {
                maxD = Math.max(maxD, prices[i]-minP);
            }
            leftMax[i] = maxD;
        }
        int[] rightMax = new int[prices.length];
        int maxP = prices[prices.length-1];
        maxD = 0;
        for (int i=prices.length-2; i>=0; i--){
            if (prices[i]>maxP){
                maxP = prices[i];
            }
            else {
                maxD = maxP-prices[i];
                rightMax[i] = maxD;
            }
        }

        int maxProfit = 0;
        for (int i=0;i<prices.length;i++){
            maxProfit = Math.max(maxProfit, leftMax[i]+rightMax[i]);
        }
        return maxProfit;
    }
}
