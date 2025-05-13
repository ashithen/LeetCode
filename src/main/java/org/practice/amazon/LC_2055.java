package org.practice.amazon;

public class LC_2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] sArr = s.toCharArray();
        int[] lBrackets = new int[sArr.length];
        int[] rBrackets = new int[sArr.length];
        int[] pCounts = new int[sArr.length];
        int lB=-1;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == '|'){
                lB = i;
            }
            lBrackets[i] = lB;
        }
        int rB=-1;
        for (int i=sArr.length-1; i>=0; i--) {
            if (sArr[i] == '|'){
                rB = i;
            }
            rBrackets[i] = rB;
        }
        int count=0;
        for (int i=0; i<sArr.length; i++) {
            if (sArr[i] == '|'){
                pCounts[i] = count;
            }
            else {
                count++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            int lIndex = rBrackets[queries[i][0]];
            int rIndex = lBrackets[queries[i][1]];
            if (lIndex != -1 && rIndex != -1){
                answer[i] = Math.max(pCounts[rIndex] - pCounts[lIndex], 0);
            }
        }
        return answer;
    }
}
