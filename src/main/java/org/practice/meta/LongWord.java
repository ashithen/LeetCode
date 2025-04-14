package org.practice.meta;

import java.util.ArrayList;
import java.util.List;

class WNode{
    char c;
    boolean isEnd;
    WNode[] nodeMap;

    public WNode(char c){
        this.c = c;
        this.isEnd = false;
        this.nodeMap = new WNode[26];
    }
}
public class LongWord {

    private WNode headNode;
    private String res;
    private void addWord(String s){
        WNode curr = headNode;
        for (char c : s.toCharArray()){
            int i = c-'a';
            if (curr.nodeMap[i] != null){
                curr = curr.nodeMap[i];
            }
            else {
                WNode nNode = new WNode(c);
                curr.nodeMap[i] = nNode;
                curr = nNode;
            }
        }
        curr.isEnd = true;
    }

    private String getString(List<Character> cList){
        StringBuilder sb = new StringBuilder();
        for (Character c : cList){
            sb.append(c);
        }
        return sb.toString();
    }

    private void checkForMax(WNode wNode, List<Character> cList){
        if (wNode.isEnd && cList.size() > this.res.length()){
            this.res = this.getString(cList);
        }
        for (WNode cNode : wNode.nodeMap){
            if (cNode == null || !cNode.isEnd){
                continue;
            }
            cList.add(cNode.c);
            this.checkForMax(cNode, cList);
            cList.remove(cList.size()-1);
        }
    }
    public String longestWord(String[] words) {

        this.headNode = new WNode('$');
        this.res = "";
        for (String w : words){
            this.addWord(w);
        }
        this.checkForMax(this.headNode, new ArrayList<>());
        return this.res;
    }
}
