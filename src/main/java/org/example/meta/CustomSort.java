package org.example.meta;

import java.util.*;

public class CustomSort {

    public String customSortString(String order, String s) {
        Map<Character, Integer> oMap = new HashMap<>();
        for (char c : order.toCharArray()){
            oMap.put(c,0);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (oMap.containsKey(c)){
                oMap.put(c,oMap.get(c)+1);
            }
            else {
                sb.append(c);
            }
        }
        for (char c : order.toCharArray()){
            int count = oMap.get(c);
            if (count == 0){
                continue;
            }
            sb.append(String.valueOf(c).repeat(count));
        }
        return sb.toString();
    }
}
