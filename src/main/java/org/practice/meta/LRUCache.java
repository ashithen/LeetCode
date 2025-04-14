package org.practice.meta;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

class LinkNode {
    LinkNode prev;
    LinkNode next;
    int key;

    public LinkNode(int key) {
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {

    private int capacity;
    private Map<Integer, Pair<LinkNode, Integer>> valueMap;
    private LinkNode head;
    private LinkNode curr;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.valueMap = new HashMap<>();
        this.head = null;
        this.curr = null;
    }

    private void moveNodeToLast(LinkNode node) {
        if (node == curr){
            return;
        }
        if (node.prev != null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        else {
            node.next.prev = null;
            this.head = node.next;
        }
        this.curr.next = node;
        node.prev = this.curr;
        this.curr = node;
    }

    private LinkNode addKeyNode(int key){
        LinkNode node = new LinkNode(key);
        if (this.curr == null){
            this.head = node;
            this.curr = node;
        }
        else {
            this.curr.next = node;
            node.prev = this.curr;
            this.curr = node;
        }
        return node;
    }

    private int removeHead(){
        int key = this.head.key;
        this.head = this.head.next;
        return key;
    }

    public int get(int key) {
        if (!this.valueMap.containsKey(key)){
            return -1;
        }
        Pair<LinkNode, Integer> pair = this.valueMap.get(key);
        this.moveNodeToLast(pair.getKey());
        return pair.getValue();
    }

    public void put(int key, int value) {
        if (this.valueMap.containsKey(key)){
            Pair<LinkNode, Integer> pair = this.valueMap.get(key);
            this.moveNodeToLast(pair.getKey());
            this.valueMap.put(key, new Pair<>(pair.getKey(), value));
        }
        else {
            if (valueMap.size() == this.capacity) {
                int keyToRemove = this.removeHead();
                valueMap.remove(keyToRemove);
            }
            LinkNode node = this.addKeyNode(key);
            this.valueMap.put(key, new Pair<>(node, value));
        }
    }
}
