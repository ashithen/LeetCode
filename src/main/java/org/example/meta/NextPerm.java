package org.example.meta;

public class NextPerm {

    private void swap(int[] nums, int m, int n){
        int t = nums[m];
        nums[m] = nums[n];
        nums[n] = t;
    }
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while (i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        int swapStart = 0;
        if (i >= 0){
            int minIndex = i+1;
            for (int j=i+2; j<nums.length; j++){
                if (nums[j] > nums[i] && nums[j] <= nums[minIndex]){
                    minIndex = j;
                }
            }
            this.swap(nums,i,minIndex);
            swapStart = i+1;
        }

        int l = nums.length-1;
        while (swapStart < l){
            this.swap(nums, swapStart,l);
            swapStart++;
            l--;
        }
    }

    public static void main(String[] args) {

    }
}
