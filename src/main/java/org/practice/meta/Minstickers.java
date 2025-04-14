package org.practice.meta;

import java.util.*;

public class Minstickers {

    private boolean notComplete(String[] stickers, String target){
        Set<Character> tSet = new HashSet<>();
        for (char c : target.toCharArray()){
            tSet.add(c);
        }
        for (String s : stickers){
            for (char c : s.toCharArray()){
                tSet.remove(c);
            }
            if (tSet.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public int minStickers(String[] stickers, String target) {
        if (notComplete(stickers, target)){
            return -1;
        }

        Map<String, Integer> cMap = new HashMap<>();
        cMap.put(target, 0);
        while (true){
            Map<String, Integer> nextLeft = new HashMap<>();
            for (Map.Entry<String, Integer> e : cMap.entrySet()){
                for (String s : stickers){
                    String tC = e.getKey();
                    for (char c : s.toCharArray()){
                        tC = tC.replace(Character.toString(c),"");
                    }
                    if (tC.isEmpty()){
                        return e.getValue()+1;
                    }
                    int step = cMap.containsKey(tC) ? e.getValue() : e.getValue()+1;
                    nextLeft.put(tC, Math.min(step, nextLeft.getOrDefault(tC,step)));
                }
            }
            cMap = nextLeft;
        }
    }
}
