package org.practice.meta;

import java.util.HashMap;
import java.util.Map;

public class PrimeSub {

    private Map<Integer, Integer> nextPrimes;
    
    private boolean isPrime(int num){
        if (num <= 1){
            return false;
        } else if (num <= 3) {
            return true;
        } else if (num%2 == 0 || num%3 == 0) {
            return false;
        }

        int i=5;
        while (i*i <= num){
            if (num%i == 0 || num%(i+2)==0){
                return false;
            }
            i += 6;
        }
        return true;
    }

    private int getNextPrime(int n){
        if (this.nextPrimes.containsKey(n)){
            return this.nextPrimes.get(n);
        }
        int nextP;
        if (this.isPrime(n)){
            nextP = n;
        }
        else {
            nextP = getNextPrime(n+1);
        }
        this.nextPrimes.put(n, nextP);
        return nextP;
    }

    public boolean primeSubOperation(int[] nums) {
        this.nextPrimes = new HashMap<>();
        int cMin = 1001;
        for (int i= nums.length-1; i>=0; i--){
            if (nums[i] <= cMin){
                cMin = nums[i];
            }
            else {
                int prime = this.getNextPrime(nums[i]-cMin);
                if (prime >= nums[i]){
                    return false;
                }
                cMin = nums[i]-prime;
            }
            cMin--;
        }
        return true;
    }
}
