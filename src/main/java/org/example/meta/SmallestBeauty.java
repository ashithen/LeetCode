package org.example.meta;

public class SmallestBeauty {

    int[] chars;


    private boolean isBeautiful(){
        for (int i=chars.length-1; i>0; i--){
            if (chars[i] == chars[i-1] || (i>1 && chars[i] == chars[i-2])){
                return false;
            }
        }
        return true;
    }

    private String generateString(){
        StringBuilder sb = new StringBuilder();
        for (int c : chars){
            sb.append((char) (c+'a'));
        }
        return sb.toString();
    }
    public String smallestBeautifulString(String s, int k) {
        chars = new int[s.length()];
        for (int i=0; i<s.length(); i++){
            chars[i] = s.charAt(i)-'a';
        }
        while (true){
            int i = chars.length-1;
            while (i >= 0){
                chars[i]++;
                if (chars[i] == k){
                    chars[i] = 0;
                    i--;
                }
                else {
                    break;
                }
            }
            if (i < 0){
                break;
            }
            if (isBeautiful()){
                return generateString();
            }
        }
        return "";
    }
}
