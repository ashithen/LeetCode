package org.example.meta;

import java.util.*;

class TrieN{
    char c;
    Map<Character, TrieN> nodesMap;

    public TrieN(char c){
        this.c = c;
        nodesMap = new HashMap<>();
    }

    public TrieN addAndGetNextNode(char c){
        if (!nodesMap.containsKey(c)){
            nodesMap.put(c,new TrieN(c));
        }
        return nodesMap.get(c);
    }
}

class TrieData{
    TrieN head;

    public TrieData(){
        this.head = new TrieN('$');
    }

    public void addWord(String word){
        TrieN curr = head;
        for (char c : word.toCharArray()){
            curr = curr.addAndGetNextNode(c);
        }
        curr.addAndGetNextNode('*');
    }
}

public class WordBreak {

    private TrieData trieData;
    private char[] chars;
    private Set<Integer> failSet;

    private boolean checkWord(int index){
        if (index == chars.length){
            return true;
        }
        if (failSet.contains(index)){
            return false;
        }
        TrieN curr = this.trieData.head;

        for (int i=index; i<chars.length; i++){
            if (!curr.nodesMap.containsKey(chars[i])){
                failSet.add(index);
                return false;
            }
            curr = curr.nodesMap.get(chars[i]);
            if (curr.nodesMap.containsKey('*') && this.checkWord(i+1)){
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.trieData = new TrieData();
        for (String w : wordDict){
            trieData.addWord(w);
        }
        this.chars = s.toCharArray();
        failSet = new HashSet<>();
        return checkWord(0);
    }
}
