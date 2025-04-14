package org.example.meta;

import java.util.*;

public class MergeAccounts {

    private int[] parent;

    private boolean isSame(List<String> acc1, List<String> acc2){
        Set<String> allSet = new HashSet<>(acc1);
        allSet.addAll(acc2);
        return allSet.size() < acc1.size()+acc2.size()-1;
    }

    private int getParent(int index){
        if (parent[index] == index){
            return index;
        }
        parent[index] = this.getParent(parent[index]);
        return parent[index];
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        this.parent = new int[accounts.size()];
        for (int i=0; i<accounts.size(); i++){
            int p = i;
            for (int j=0; j<i;j++){
                if (p == getParent(j) || this.isSame(accounts.get(i),accounts.get(j))){
                    p = Math.min(p,j);
                    parent[j] = p;
                }
            }
            parent[i] = p;
        }
        Map<Integer, Set<String>> res = new HashMap<>();
        for (int i=0; i<accounts.size(); i++){
            int p = getParent(i);
            if (res.containsKey(p)){
                res.get(p).addAll(accounts.get(i));
            }
            else {
                res.put(p,new HashSet<>(accounts.get(i)));
            }
        }
        List<List<String>> output = new ArrayList<>();
        for (Set<String> resVals : res.values()){
            List<String> sList = new ArrayList<>(resVals);
            sList.sort(String::compareTo);
            output.add(sList);
        }
        return output;
    }
}
