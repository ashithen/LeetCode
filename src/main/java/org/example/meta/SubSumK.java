package org.example.meta;

import java.util.HashMap;
import java.util.Map;

public class SubSumK {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        int sum = 0;
        for (int n : nums){
            sum += n;
            if (sum == k){
                res++;
            }
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()){
                if (sum-entry.getKey() == k){
                    res += entry.getValue();
                }
            }
            counts.put(sum, counts.getOrDefault(sum,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int k = 3;
        System.out.println(new SubSumK().subarraySum(arr, k));
    }
}
