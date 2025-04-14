package org.example.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    private String getKey(String s){
        int[] counts = new int[26];
        for (char c : s.toCharArray()){
            counts[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int n : counts){
            sb.append(n).append(' ');
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs){
            String key = getKey(s);
            res.computeIfAbsent(key, a->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
