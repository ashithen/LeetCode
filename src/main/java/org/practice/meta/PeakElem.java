package org.practice.meta;

import java.util.ArrayList;
import java.util.List;

public class PeakElem {

    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1]){
            return 0;
        }
        if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }
        int low = 1;
        int high = nums.length-2;

        while (low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }
            if (nums[mid] <= nums[high]){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> mm = new ArrayList<>();
        mm.add(5);
        mm.addAll(new ArrayList<>());
    }
}
