package org.practice.meta;

import java.util.ArrayList;
import java.util.List;

public class BitWiseAndWrong {

    private int[] parents;

    private void setParent(int index, int val){
        if (parents[index] != index){
            setParent(parents[index],val);
        }
        parents[index] = val;
    }

    private int getParent(int index){
        if (parents[index] != index){
            parents[index] = getParent(parents[index]);
        }
        return parents[index];
    }
    public int largestCombination(int[] candidates) {
        parents = new int[candidates.length];
        for (int i=0; i< candidates.length; i++){
            parents[i] = i;
        }
        int n=1;
        for (int i=0; i<32; i++){
            n <<= i;
            List<Integer> common = new ArrayList<>();
            int minParent = Integer.MAX_VALUE;
            for (int j=0; j<candidates.length; j++){
                if ((candidates[j]&n) > 0){
                    common.add(j);
                    minParent = Math.min(minParent, getParent(j));
                }
            }
            for (int index : common) {
                setParent(index,minParent);
            }
        }
        int ans = 0;
        int[] cArr = new int[candidates.length];
        for (int i=0; i< candidates.length; i++){
            int parent = getParent(i);
            cArr[parent]++;
            ans = Math.max(ans, cArr[parent]);
        }
        return ans;

    }
}
