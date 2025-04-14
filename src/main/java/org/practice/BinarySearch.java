package org.practice;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public int doSearch(List<Integer> nums, int key){
        int low = 0;
        int high = nums.size()-1;
        int res = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (nums.get(mid) == key){
                return mid;
            } else if (nums.get(mid) < key) {
                if (res == -1 || (Math.abs(nums.get(mid) - key) < Math.abs(nums.get(res) - key))){
                    res = mid;
                }
                low = mid+1;
            }
            else {
                if (res == -1 || (Math.abs(nums.get(mid) - key) < Math.abs(nums.get(res) - key))){
                    res = mid;
                }
                high = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> nums = Arrays.asList(1,5,9,14,17,18,20,25,30);
        int key = -77;
        System.out.println(nums.get(binarySearch.doSearch(nums, key)));
    }
}


