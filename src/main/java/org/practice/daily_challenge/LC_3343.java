package org.practice.daily_challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LC_3343 {

    int[] digits;
    int total;
    int ans;
    int MOD = 1000000007;
    Map<Integer, Long> comboCountCache;

    private long getComboCount(int n){
        if (comboCountCache.containsKey(n)){
            return comboCountCache.get(n);
        }
        else {
            long comboCount = 1;
            for (int i = 2; i <= n; i++) {
                comboCount *= i;
                comboCount %= MOD;
            }
            comboCountCache.put(n, comboCount);
            return comboCount;
        }
    }

    private long getComboNumber(int[] arr) {
        int count = IntStream.of(arr).sum();
        long comboCount = getComboCount(count);
        for (int c : arr){
            if (c > 1){
                comboCount /= this.getComboCount(c);
                comboCount %= MOD;
            }
        }
        return comboCount;
    }

    private void calculate(int[] arr1, int[] arr2) {
        long c1 = getComboNumber(arr1);
        long c2 = getComboNumber(arr2);
        long totalCombo = (c1*c2)%MOD;
        if (IntStream.of(arr1).sum() == IntStream.of(arr2).sum()){
            totalCombo *= 2;
            totalCombo %= MOD;
        }
        ans += (int) totalCombo;
        ans %= MOD;
    }
    private void doCombo(int index, int[] arr1, int[] arr2, int diff, int digitLeft) {
        if (Math.abs(diff) > digitLeft) {
            return;
        }
        if (index == digits.length){
            if (diff == 0){
                calculate(arr1, arr2);
            }
            return;
        }

        digitLeft -= digits[index];
        arr1[digits[index]]++;
        diff += digits[index];
        this.doCombo(index + 1, arr1, arr2, diff, digitLeft);
        arr1[digits[index]]--;

        arr2[digits[index]]++;
        diff -= 2*digits[index];
        this.doCombo(index + 1, arr1, arr2, diff, digitLeft);
        arr2[digits[index]]--;
    }

    public int countBalancedPermutations(String num) {
        digits = new int[num.length()];
        total = 0;
        ans = 0;
        comboCountCache = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            digits[i] = num.charAt(i) - '0';
            total += digits[i];
        }
        if (total%2 == 1){
            return 0;
        }
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        this.doCombo(0, arr1, arr2, 0, total);
        return ans/2;
    }
}
