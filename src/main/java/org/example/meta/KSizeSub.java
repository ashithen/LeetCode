package org.example.meta;

public class KSizeSub {

    public int[] resultsArray(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int s=0;
        for (int i=1; i<k; i++){
            if (nums[i]-nums[i-1]==1){
                s++;
            }
        }
        res[0]=s==k-1 ? nums[k] : -1;
        int p1=0;
        int p2=k;
        int rI = 1;
        while (p2 < nums.length-1){
            if (nums[p2]-nums[p2-1]==1){
                s++;
            }
            if (nums[p1+1]-nums[p1]==1){
                s--;
            }
            res[rI]=s==k-1 ? nums[k] : -1;
            rI++; p2++; p1++;
        }
        return res;
    }
}
