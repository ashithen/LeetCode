package org.example.meta;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()){
            return "";
        }
        if (s.equals(t)){
            return s;
        }
        Map<Character,Integer> refMap = new HashMap<>();
        Map<Character, Integer> cMap = new HashMap<>();
        int misMatch = t.length();

        for (char c : t.toCharArray()){
            refMap.put(c, refMap.getOrDefault(c,0)+1);
            cMap.put(c, cMap.getOrDefault(c, 0)+1);
        }

        int sI=0;
        int eI=0;
        int mSI=0;
        int mEI = s.length()+1;

        while (eI < s.length() || (eI == s.length() && misMatch==0)){
            if (misMatch > 0){
                char c = s.charAt(eI);
                eI++;
                if (refMap.containsKey(c)){
                    cMap.put(c,cMap.get(c)-1);
                    if (cMap.get(c) >= 0){
                        misMatch--;
                    }
                }
            }
            else {
                char c = s.charAt(sI);
                sI++;
               if (refMap.containsKey(c)){
                   cMap.put(c, cMap.get(c)+1);
                   if (cMap.get(c) > 0){
                       misMatch++;
                   }
               }
            }
//            if (misMatch == 0){
//                System.out.printf("s: %d  e: %d\n",sI, eI);
//            }
//            else {
//                System.out.printf("mis %d s:%d e:%d\n",misMatch,sI,eI);
//            }
            if (misMatch == 0 && (eI-sI < mEI-mSI)){
                mEI = eI;
                mSI = sI;
            }
        }
        return mEI == s.length()+1 ? "" : s.substring(mSI, mEI);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinWindow().minWindow(s,t));
    }
}
