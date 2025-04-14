package org.example.meta;

import java.util.HashSet;
import java.util.Set;

public class MaxUnique {

    private String s;
    private Set<String> stringSet;
    private int maxRes;
    private void spiltIt(int index){
        if (index == s.length()){
            maxRes = Math.max(maxRes, this.stringSet.size());
            return;
        }
        for (int i=index+1; i<=this.s.length(); i++){
            String cs = this.s.substring(index,i);
            if (this.stringSet.contains(cs)){
                continue;
            }
            if (stringSet.size()+s.length()-i+1 <= maxRes){
                break;
            }
            this.stringSet.add(cs);
            this.spiltIt(i);
            this.stringSet.remove(cs);
        }
    }

    public int maxUniqueSplit(String s) {
        this.s = s;
        this.stringSet = new HashSet<>();
        this.maxRes = 0;
        this.spiltIt(0);
        return maxRes;
    }

    public static void main(String[] args) {
//        String s = "wwwwwwwwwwwwwwww";
//        System.out.println(new MaxUnique().maxUniqueSplit(s));
        System.out.println(-25%26);
    }
}
