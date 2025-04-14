package org.practice.meta;

public class RotateBox {

    public char[][] rotateTheBox(char[][] box) {
        char[][] res = new char[box[0].length][box.length];
        for (int i=0; i<box.length; i++) {
            int m = box.length-1-i;
            int j = box[i].length-1;
            int pBlock = box[i].length;
            while (j>=0){
                int sCount = 0;
                while (j>=0 && box[i][j] != '*'){
                    if (box[i][j] == '#'){
                        sCount++;
                    }
                    j--;
                }
                for (int k=pBlock-1; k>j; k--){
                    res[k][m] = sCount > 0 ? '#' : '.';
                    sCount--;
                }
                if (j>=0){
                    res[j][m] = '*';
                }
                pBlock=j;
                j--;
            }
        }
        return res;
    }
}
