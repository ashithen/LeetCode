package org.example.meta;

public class KthPos {

    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        int res = 0;

        while (low <= high){
            int mid = (low+high)/2;
            int c = arr[mid]-(mid+1);
            if (c >= k){
                high = mid-1;
                res = mid;
            }
            else {
                low = mid+1;
            }
        }
        return k+res;
    }
}
