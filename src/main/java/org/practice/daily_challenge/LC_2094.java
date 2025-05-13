package org.practice.daily_challenge;

import java.util.*;

public class LC_2094 {

    private boolean isValid(int num, int[] digitCount) {
        int d1 = num/100;
        int d2 = (num%100)/10;
        int d3 = num%10;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(d1, map.getOrDefault(d1, 0) + 1);
        map.put(d2, map.getOrDefault(d2, 0) + 1);
        map.put(d3, map.getOrDefault(d3, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (digitCount[entry.getKey()] < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    public int[] findEvenNumbers(int[] digits) {
        int[] digitCount = new int[10];
        for (int digit : digits) {
            digitCount[digit]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int num = 100; num <1000; num+=2) {
            if (isValid(num, digitCount)) {
                ans.add(num);
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}
