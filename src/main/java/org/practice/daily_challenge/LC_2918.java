package org.practice.daily_challenge;

import javafx.util.Pair;

public class LC_2918 {

    private Pair<Long, Long> getSumAndZeroCount(int[] nums) {
        long zeroCount = 0;
        long sum = 0;
        for (int n : nums) {
            if (n == 0) {
                zeroCount++;
            } else {
                sum += n;
            }
        }
        return new Pair<>(sum, zeroCount);
    }

    public long minSum(int[] nums1, int[] nums2) {
        Pair<Long, Long> pair1 = getSumAndZeroCount(nums1);
        Pair<Long, Long> pair2 = getSumAndZeroCount(nums2);
        if (pair1.getValue() == 0 && pair2.getValue() == 0) {
            return pair1.getKey().equals(pair2.getKey()) ? pair1.getKey() : -1;
        } else if (pair1.getValue() == 0) {
            if (pair1.getKey() <= pair2.getKey()) {
                return -1;
            } else {
                return pair1.getKey() - pair2.getKey() >= pair2.getValue() ? pair1.getKey() : -1;
            }
        } else if (pair2.getValue() == 0) {
            if (pair2.getKey() <= pair1.getKey()) {
                return -1;
            } else {
                return pair2.getKey() - pair1.getKey() >= pair1.getValue() ? pair2.getKey() : -1;
            }
        }

        return Math.max(pair1.getKey() + pair1.getValue(), pair2.getKey() + pair2.getValue());
    }
}
