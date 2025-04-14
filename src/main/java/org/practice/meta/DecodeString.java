package org.practice.meta;

public class DecodeString {

    int index;
    char[] sArr;

    private String getString(){
        StringBuilder sb = new StringBuilder();
        while (sArr[index] != ']'){
            while (!Character.isDigit(sArr[index])){
                sb.append(sArr[index]);
                index++;
            }
            int d = 0;
            while (Character.isDigit(sArr[index])){
                d *= 10;
                d += Character.digit(sArr[index],10);
                index++;
            }
            if (sArr[index] == '['){
                index++;
                String nextString = getString();
                for (int i=0; i<d; i++){
                    sb.append(nextString);
                }
            }
        }
        index++;
        return sb.toString();
    }

    public String decodeString(String s) {
        sArr = s.toCharArray();
        index = 0;
        return getString();
    }
}
