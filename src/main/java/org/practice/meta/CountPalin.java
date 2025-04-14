package org.practice.meta;

public class CountPalin {

    public int countSubstrings(String s) {
        char[] cArr = s.toCharArray();
        int count = cArr.length;
        for (int i = 1; i < cArr.length-1; i++) {
            int j = 1;
            while ((i-j)>=0 && (i+j)<cArr.length && cArr[i-j]==cArr[i+j]){
                count++;
                j++;
            }
        }
        for (int i=1; i<cArr.length-2; i++) {
            if (cArr[i]!=cArr[i+1]) {
                continue;
            }
            int j=1;
            while ((i-j)>=0 && (i+1+j)<cArr.length && cArr[i-j]==cArr[i+1+j]){
                count++;
                j++;
            }
        }
        return count;
    }
}
