package org.practice.google;

public class LC7 {
    public int reverse(int x) {
        boolean isNeg = x<0;
        char[] chars = Long.toString(Math.abs((long)x)).toCharArray();
        for (int i=0; i<chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = temp;
        }
        Long ans = Long.parseLong(new String(chars));
        if (isNeg) ans = -ans;
        if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE) {
            return 0;
        }
        return ans.intValue();
    }
}
