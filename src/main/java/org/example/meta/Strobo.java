package org.example.meta;

import java.util.HashMap;
import java.util.Map;

public class Strobo {

    private static Map<Character, Character> sMap = new HashMap<Character, Character>() {{
        put('0', '0');
        put('1','1');
        put('5','5');
        put('6','9');
        put('8','8');
        put('9','6');
    }};

    public boolean isStrobogrammatic(String num) {
        int i=0;
        int j = num.length()-1;
        while (i<=j){
            char c1 = num.charAt(i++);
            char c2 = num.charAt(j--);
            if (!sMap.containsKey(c1) || sMap.get(c1) != c2){
                return false;
            }
        }
        return true;
    }
}
