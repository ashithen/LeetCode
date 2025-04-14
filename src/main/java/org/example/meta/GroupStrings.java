package org.example.meta;

import java.util.*;


public class GroupStrings {

    private int getCode(String val){
        List<Integer> codes = new ArrayList<>();
        int first = val.charAt(0);
        for (int i=1; i<val.length(); i++){
            int diff = ((int)val.charAt(i))-first;
            if (diff < 0){
                diff += 26;
            }
            codes.add(diff);
        }
        return codes.hashCode();
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<Integer, List<String>> strMap = new HashMap<>();
        for (String str : strings){
            int code = getCode(str);
            if (strMap.containsKey(code)){
                strMap.get(code).add(str);
            }
            else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                strMap.put(code, newList);
            }
        }
        return new ArrayList<>(strMap.values());
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"abc","bcd","acef","xyz","az","ba","a","z"};
        new GroupStrings().groupStrings(strings);
    }
}
