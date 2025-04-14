package org.example.meta;

public class MaxPrefix {
    public String longestCommonPrefix(String[] strs) {
        int count = 0;
        for (int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            boolean allMatch = true;
            for (int j=1; j< strs.length; j++){
                if (i == strs[j].length() || c != strs[j].charAt(i)){
                    allMatch = false;
                    break;
                }
            }
            if (allMatch){
                count++;
            }
            else {
                break;
            }
        }
        return strs[0].substring(0,count);
    }
}
