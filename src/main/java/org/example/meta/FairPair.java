package org.example.meta;

import java.util.Arrays;

public class FairPair {

    private int getLowerIndex(int[] nums, int target, int low, int high){
        if (target <= 0 || nums[low] >= target){
            return low;
        } else if (high < target) {
            return -1;
        }
        int res = -1;
        while (low <= high){
            int mid = (low+high)/2;
            if (nums[mid] < target){
                low = mid+1;
            }
            else {
                high = mid-1;
                res = high;
            }
        }
        return res;
    }

    private int getHigherIndex(int[] nums, int target, int low, int high){
        if (nums[high] < target){
            return high;
        } else if (nums[low] > target) {
            return -1;
        }
        int res = -1;
        while (low <= high){
            int mid = (low+high)/2;
            if (nums[mid] <= target){
                low = mid+1;
                res = mid;
            }
            else {
                high = mid-1;
            }
        }
        return res;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long answer = 0;
        int lowB = nums.length-1;
        int highB = nums.length-1;
        for (int i=0; i< nums.length-1; i++){
            int low = getLowerIndex(nums, lower-nums[i],i+1,lowB);
            int high = getHigherIndex(nums, upper-nums[i], i+1,highB);
            if (low == -1 || high == -1){
                break;
            }
            answer += high-low+1;
            lowB = low;
            highB = high;
        }
        return answer;
    }
}
