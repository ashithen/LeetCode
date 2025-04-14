package org.practice.meta;

public class KBit {

    private int getPrev(int k){
        int m=2;
        while (m < k){
            m = m << 1;
        }
        return m-k;
    }
    public char findKthBit(int n, int k) {
        boolean isSame = true;
        while (k > 1){
            k = this.getPrev(k);
            isSame = !isSame;
        }
        return isSame ? '0' : '1';
    }

    public static void main(String[] args) {
        System.out.println(new KBit().findKthBit(1,12));
    }
}
