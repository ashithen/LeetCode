package org.practice.meta;

public class ValidNum {
    
    private boolean isValidExponential(String s, int index){
        boolean isDigitDone = false;
        boolean isSignDone = false;
        while (index < s.length()){
            char c = s.charAt(index);
            if (Character.isDigit(c)){
                isDigitDone = true;
            } else if (c=='-' || c=='+') {
                if (isDigitDone || isSignDone){
                    return false;
                }
                isSignDone = true;
            } else {
                return false;
            }
            index++;
        }
        return isDigitDone;
    }

    public boolean isNumber(String s) {
        int i=0;
        boolean isFirstDigitDone = false;
        boolean isPeriodDone = false;
        boolean isSignDone = false;

        while (i < s.length()){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                isFirstDigitDone = true;
            }
            else if (c == '-' || c == '+'){
                if (isSignDone || isPeriodDone || isFirstDigitDone){
                    return false;
                }
                isSignDone = true;
            } else if (c == '.') {
                if (isPeriodDone){
                    return false;
                }
                isPeriodDone = true;
            } else if (c == 'e' || c == 'E') {
                return this.isValidExponential(s, i+1);
            }
            i++;
        }

        return isFirstDigitDone;
    }
}
