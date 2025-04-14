package org.example.meta;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int nearest = nums.length-1;
        for (int i= nums.length-2; i>=0; i--){
            if (nums[i]+i >= nearest){
                nearest = i;
            }
        }
        return nearest == 0;
    }
}
