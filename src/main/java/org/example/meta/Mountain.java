package org.example.meta;

public class Mountain {

    public int minimumMountainRemovals(int[] nums) {
        int[] left = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            int count = 0;
            for (int j=0; j<i; j++){
                if (nums[j] < nums[i]){
                    count = Math.max(count, left[j]);
                }
            }
            left[i] = count+1;
        }

        StringBuilder sb = new StringBuilder();
        for (int l : left){
            sb.append(l).append(' ');
        }
        System.out.println(sb);

        int[] right = new int[nums.length];
        for (int i=nums.length-1; i>=0; i--){
            int count = 0;
            for (int j=nums.length-1; j>i; j--){
                if (nums[i] > nums[j]){
                    count = Math.max(count, right[j]);
                }
            }
            right[i] = count+1;
        }

        StringBuilder sbr = new StringBuilder();
        for (int r : right){
            sbr.append(r).append(' ');
        }
        System.out.println(sbr);

        int total = 0;
        for (int i=0; i< left.length; i++){
            if (left[i]>1 && right[i]>1) {
                total = Math.max(total, left[i] + right[i]);
            }
        }
        return nums.length-total+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100,92,89,77,74,66,64,66,64};
        System.out.println(new Mountain().minimumMountainRemovals(arr));
    }
}
