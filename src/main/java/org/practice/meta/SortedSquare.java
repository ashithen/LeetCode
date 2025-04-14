package org.practice.meta;

public class SortedSquare {

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int j = 0;

        while (j < nums.length){
            if (nums[j] >= 0){
                break;
            }
            j++;
        }
        int i=j-1;
        int k=0;
        while (i>=0 && j< nums.length){
            if (-nums[i] < nums[j]){
                res[k] = nums[i]*nums[i];
                i--;
            }
            else {
                res[k] = nums[j]*nums[j];
                j++;
            }
            k++;
        }
        while (i>=0){
            res[k++] = nums[i]*nums[i];
            i--;
        }
        while (j< nums.length){
            res[k++] = nums[j]*nums[j];
            j++;
        }
        return res;
    }

}
