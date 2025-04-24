package org.practice.daily_challenge;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LC3272 {

    private Set<String> digitSet;

    private String getStringFor(int[] arr){
        Arrays.sort(arr);
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
    private boolean isKPalindrome(int[] arr, int k) {
        if (arr[0] == 0){
            return false;
        }
        long num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            num *= 10;
            num += arr[i];
        }
        return num%k==0;
    }

    private void doCombination(int[] arr, int index, int k){

    }
    public long countGoodIntegers(int n, int k) {

    }
}
