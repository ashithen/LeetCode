package org.practice.meta;

public class IntConvert {

    public int myAtoi(String s) {
        boolean isNegative = false;
        boolean isDigitStarted = false;
        long res = 0;
        long bound = (long) Math.pow(2,31);

        for (char c : s.toCharArray()){
            if (!Character.isDigit(c)){
                if (isDigitStarted){
                    break;
                }
                if (c == '+'){
                    isDigitStarted = true;
                } else if (c == '-') {
                    isNegative = true;
                    isDigitStarted = true;
                } else if (c != ' ') {
                    break;
                }
            }
            else {
                isDigitStarted = true;
                int num = c-'0';
                res *= 10;
                res += num;
            }
            if (res >= bound){
                break;
            }
        }
        if (isNegative){
            res *= -1;
        }
        int out;
        if (res > Integer.MAX_VALUE){
            out = Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            out = Integer.MIN_VALUE;
        }
        else {
            out = (int) res;
        }
        return out;
    }
}
