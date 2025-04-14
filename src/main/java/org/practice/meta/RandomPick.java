package org.practice.meta;

import java.util.*;

public class RandomPick {

    private final Map<Integer, List<Integer>> indexMap;
    private final Random random;
    public RandomPick(int[] nums) {
        indexMap = new HashMap<>();
        random = new Random();
        for (int i=0; i<nums.length; i++){
            indexMap.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        int i = random.nextInt(indexMap.get(target).size());
        return indexMap.get(target).get(i);
    }

    public static void main(String[] args) {
        int[] test = new int[3];
        System.out.println(test[-1]);
    }
}
