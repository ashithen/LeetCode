package org.example.meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountEncode {

    public String countAndSay(int n) {
        int s=1;
        List<Character> cList = Collections.singletonList('1');
        while (s<n){
            List<Character> nList = new ArrayList<>();
            Character lC = cList.get(0);
            int count = 1;
            for (int i=1; i<cList.size(); i++){
                if (cList.get(i) != lC){
                    nList.add((char)(count+'0'));
                    nList.add(lC);
                    count=1;
                    lC=cList.get(i);
                }
                count++;
            }
            nList.add((char)(count+'0'));
            nList.add(lC);
            s++;
            cList = nList;
        }
        StringBuilder sb = new StringBuilder();
        cList.forEach(sb::append);
        return sb.toString();
    }
}
