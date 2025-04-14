package org.practice.daily_challenge;

public class MinSumPartition {

    public int split(int index, int[] nums, int A, int B, int aLeft, int bLeft) {
        if (index == nums.length) {
            return Math.abs(A - B);
        }
        int minDiff = Integer.MAX_VALUE;
        if (aLeft > 0) {
            minDiff = this.split(index + 1, nums, A + nums[index], B, aLeft - 1, bLeft);
        }
        if (bLeft > 0){
            minDiff = Math.min(minDiff, this.split(index+1, nums, A, B+nums[index], aLeft, bLeft-1));
        }
        return minDiff;
    }

    public int minimumDifference(int[] nums) {
        return this.split(0, nums, 0,0, nums.length/2, nums.length/2);
    }

    public static void main(String[] args) {
        int[] nums = {76, 8, 45, 20, 74, 84, 28, 1};
        MinSumPartition minSumPartition = new MinSumPartition();
        System.out.println(minSumPartition.minimumDifference(nums));
    }
}
