package org.practice.meta;

public class IsRotated {
    private boolean isMatch(String s, String goal, int offset){
        for (int i=0; i<s.length(); i++){
            int j = (i+offset)%s.length();
            if (s.charAt(i) != goal.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()){
            return false;
        }
        for (int i=0; i<s.length(); i++){
            if (isMatch(s, goal, i)){
                return true;
            }
        }
        return false;
    }
}
