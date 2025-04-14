package org.example.meta;

public class FriendRequestNum {

    public int numFriendRequests(int[] ages) {
        int[] cArr = new int[121];
        for (int age : ages) {
            cArr[age]++;
        }
        int i=0;
        int j=-1;
        int total=0;
        int iTotal=0;
        int jTotal=0;

        while (i<121){
            if (cArr[i]==0){
                i++;
                continue;
            }

            int limit = (i/2)+7;
            while ((j+1)<i && (j+1)<=limit){
                j++;
                jTotal += cArr[j];
            }
            int res = iTotal-jTotal;
            total = cArr[i]*res;
            if (i > limit){
                total += i*(i-1);
            }
            iTotal += cArr[i];
            i++;
        }
        return total;
    }
}
