package org.practice.meta;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {

    public List<Integer> findAnagrams(String s, String p) {

        int[] cArr = new int[26];
        int diff = 0;
        for (char pc : p.toCharArray()) {
            int index = pc-'a';
            if (cArr[index] == 0) {
                diff++;
            }
            cArr[index]++;
        }
        List<Integer> ans = new ArrayList<>();
        char[] sArr = s.toCharArray();
        for(int i=0; i<p.length(); i++){
            int index = sArr[i]-'a';
            cArr[index]--;
            if (cArr[index] == 0){
                diff--;
            } else if (cArr[index] == -1) {
                diff++;
            }
        }
        if (diff == 0) {
            ans.add(0);
        }
        for (int i=p.length(); i<s.length(); i++){
            int index = sArr[i]-'a';
            cArr[index]--;
            if (cArr[index] == 0){
                diff--;
            } else if (cArr[index] == -1) {
                diff++;
            }
            int sIndex = sArr[i-p.length()]-'a';
            cArr[sIndex]++;
            if (cArr[sIndex] == 0){
                diff--;
            } else if (cArr[sIndex] == 1) {
                diff++;
            }
            if (diff == 0) {
                ans.add(i-p.length()+1);
            }
        }
        return ans;
    }
}
