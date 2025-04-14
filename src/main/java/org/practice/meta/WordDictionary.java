package org.practice.meta;

import java.util.*;

class TrieNode{

    public static Character WORD_END = '*';
    char c;
    Map<Character, TrieNode> charMap;

    public TrieNode(char c){
        this.c = c;
        charMap = new HashMap<>();
    }

    public TrieNode addAndGetNode(char nc){
        if (charMap.containsKey(nc)){
            return charMap.get(nc);
        }
        TrieNode nextNode = new TrieNode(nc);
        charMap.put(nc, nextNode);
        return nextNode;
    }

    public TrieNode addWordEnd(){
        if (charMap.containsKey(WORD_END)){
            return charMap.get(WORD_END);
        }
        else {
            TrieNode lastNode = new TrieNode(WORD_END);
            charMap.put(WORD_END, lastNode);
            return lastNode;
        }
    }

    public Optional<TrieNode> getNodeFor(char c){
        if (charMap.containsKey(c)){
            return Optional.of(charMap.get(c));
        }
        else {
            return Optional.empty();
        }
    }
}
public class WordDictionary {

    TrieNode head;
    public WordDictionary() {
        head = new TrieNode('$');
    }

    public void addWord(String word) {
        TrieNode curr = this.head;
        for (char c : word.toCharArray()){
            curr = curr.addAndGetNode(c);
        }
        curr.addWordEnd();
    }

    public boolean search(String word) {
        List<TrieNode> cNodes = new ArrayList<>();
        cNodes.add(this.head);
        for (char c : word.toCharArray()){
            List<TrieNode> nextNodes = new ArrayList<>();
            if (c != '.'){
                for (TrieNode cNode : cNodes){
                    cNode.getNodeFor(c).ifPresent(nextNodes::add);
                }
            }
            else {
                for (TrieNode cNode : cNodes){
                    nextNodes.addAll(cNode.charMap.values());
                }
            }
            cNodes = nextNodes;
        }
        for (TrieNode lNode : cNodes){
            if (lNode.getNodeFor(TrieNode.WORD_END).isPresent()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("kiss");
        wordDictionary.addWord("miss");

        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("..ss"));
        System.out.println(wordDictionary.search("bvc"));
        System.out.println(wordDictionary.search("mis."));
    }
}
