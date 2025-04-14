package org.example.meta;

public class Palin {

    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;

        while (low <= high) {
            while (low <= high &&
                    !(Character.isDigit(s.charAt(low)) || Character.isUpperCase(s.charAt(low)) || Character.isLowerCase(s.charAt(low)))) {
                low++;
            }
            while (low <= high &&
                    !(Character.isDigit(s.charAt(low)) || Character.isUpperCase(s.charAt(low)) || Character.isLowerCase(s.charAt(low)))) {
                high--;
            }
            if (low > high) {
                break;
            }
            char ci = Character.toLowerCase(s.charAt(low));
            char cj = Character.toLowerCase(s.charAt(high));
            if (ci != cj) {
                return false;
            }
            low++;
            high--;
        }
        return true;

    }
}
