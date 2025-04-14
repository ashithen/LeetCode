package org.practice.meta;

public class OrSubArray {

    private int[] counts;
    private int s;
    private int[] bitNums;

    private void includeNum(int num){
        int i = 0;
        while (i<31 && bitNums[i] <= num){
            if ((bitNums[i]&num) > 0){
                counts[i]++;
                if (counts[i] == 1){
                    s += bitNums[i];
                }
            }
            i++;
        }
    }

    private void removeNum(int num){
        int i=0;
        while (i<31 && bitNums[i] <= num){
            if ((bitNums[i] & num) > 0){
                counts[i]--;
                if (counts[i] == 0){
                    s -= bitNums[i];
                }
            }
            i++;
        }
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        counts = new int[31];
        bitNums = new int[31];
        for (int i=0; i<31; i++){
            bitNums[i] = 1 << i;
        }

        s = 0;
        int j = 0;
        int i = 0;
        int minS = Integer.MAX_VALUE;

        while (j < nums.length) {
            if (nums[j] >= k) {
                minS = 1;
                break;
            } else if (s < k) {
                includeNum(nums[j]);
                j++;
            } else if (i <= j) {
                removeNum(nums[i]);
                i++;
            }
            if (s >= k) {
                minS = Math.min(minS, j - i);
            }
        }

        while (s >= k && i< nums.length-1){
            minS = Math.min(minS, j-i);
            removeNum(nums[i]);
            i++;
        }

        return minS == Integer.MAX_VALUE ? -1 : minS;
    }
}
