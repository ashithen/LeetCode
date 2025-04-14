package org.practice.meta;

public class MinSub {

    public int findLengthOfShortestSubarray(int[] arr) {
        int f=0;
        while(f<arr.length-1 && arr[f]<=arr[f+1]){
            f++;
        }

        if (f == arr.length-1){
            return 0;
        }

        int l=arr.length-1;
        while (l>0 && arr[l-1]<=arr[l]){
            l--;
        }

        int i=0;
        int j=l;
        int ans=arr.length;

        while (i<=f && j<=arr.length-1){
            ans = Math.min(ans, j-i-1);
            if (arr[i] <= arr[j]){
                i++;
            }
            else {
                j++;
            }
        }
        return ans;
    }
}
