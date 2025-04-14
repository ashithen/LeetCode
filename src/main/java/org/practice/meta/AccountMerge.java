package org.practice.meta;

import java.util.*;

public class AccountMerge {

    int[] parents;
    Set<String>[] mailSet;

    private int getParent(int i){
        if (parents[i] != i){
            parents[i] = getParent(parents[i]);
        }
        return parents[i];
    }

    private void setParent(int i, int parent){
        if (parents[i] != i){
            setParent(parents[i], parent);
        }
        parents[i] = parent;
    }

    private void merge(List<Integer> similarList){
        int min = similarList.get(0);
        for (int k : similarList){
            min = Math.min(min, k);
        }
        for (int k : similarList){
            this.setParent(k, min);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        this.parents = new int[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            parents[i] = i;
        }
        this.mailSet = new Set[accounts.size()];

        for (int i = 0; i < accounts.size(); i++) {
            mailSet[i] = new HashSet<>();
            mailSet[i].addAll(accounts.get(i).subList(1, accounts.get(i).size()));
            List<Integer> similar = new ArrayList<>();
            similar.add(i);
            for (int j = 0; j < i; j++) {
                if (accounts.get(i).get(0).equals(accounts.get(j).get(0))){
                    Set<String> intersection = new HashSet<>(mailSet[i]);
                    intersection.retainAll(mailSet[j]);
                    if (!intersection.isEmpty()){
                        similar.add(j);
                    }
                }
            }
            if (similar.size() > 1){
                this.merge(similar);
            }
        }

        Map<Integer, Set<String>> accountMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int p = this.getParent(i);
            if (accountMap.containsKey(p)){
                accountMap.get(p).addAll(mailSet[i]);
            }
            else {
                accountMap.put(p, new HashSet<>(mailSet[i]));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : accountMap.entrySet()) {
            List<String> sAccs = new ArrayList<>();
            sAccs.add(accounts.get(entry.getKey()).get(0));
            List<String> mails = new ArrayList<>(entry.getValue());
            Collections.sort(mails);
            sAccs.addAll(mails);
            result.add(sAccs);
        }
        return result;
    }
}
