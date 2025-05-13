package org.practice.daily_challenge;

import java.util.stream.IntStream;

public class LC_1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((num > 9 && num <100) || (num>999&&num<10_000) || (num>99_999&&num<10_00_000)){
                count++;
            }
        }
        return count;
    }
}
