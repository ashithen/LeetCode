package org.example.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class LNode{
    int[] data;
    LNode next;

    public LNode(int[] data){
        this.data = data;
    }
}
class GResult{
    LNode head;
    LNode tail;
    int length;

    public GResult(){
        head = null;
        tail = null;
        length = 0;
    }

    public void addNode(LNode node){
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addAll(GResult result){
        if (result.isEmpty()){
            return;
        }
        if (head == null){
            head = result.head;
            tail = result.tail;
        }
        else{
            tail.next = result.head;
            tail = result.tail;
        }
        length += result.length;
    }
}


public class ValidOrderGraph {

    private GResult getLists(Map<Integer, Stack<Integer>> nPairs, int startNode){
        GResult result = new GResult();
        int cNode = startNode;
        GResult lastNodes = new GResult();
        while (nPairs.containsKey(cNode) && !nPairs.get(cNode).isEmpty()) {
            Stack<Integer> stack = nPairs.get(cNode);
            if (stack.size() == 1){
                int node = stack.pop();
                result.addNode(new LNode(new int[]{cNode, node}));
                cNode = node;
            }
            else {
                while (!stack.isEmpty()){
                    int node = stack.pop();
                    GResult nextNodes = getLists(nPairs, node);
                    if (nextNodes.isEmpty() || nextNodes.tail.data[1] != cNode){
                        lastNodes.addNode(new LNode(new int[]{cNode, node}));
                        lastNodes.addAll(nextNodes);
                    }
                    else {
                        result.addNode(new LNode(new int[]{cNode, node}));
                        result.addAll(nextNodes);
                    }
                }
            }
        }
        if (!lastNodes.isEmpty()){
            result.addAll(lastNodes);
        }
        return result;
    }


    public int[][] validArrangement(int[][] pairs) {
      Map<Integer, Stack<Integer>> nPairs = new HashMap<>();
      Map<Integer, Integer> incomingCount = new HashMap<>();

      for (int[] pair : pairs) {
          nPairs.computeIfAbsent(pair[0], k -> new Stack<>()).add(pair[1]);
          incomingCount.put(pair[1], incomingCount.getOrDefault(pair[1], 0) + 1);
      }

      int startNode = -1;
      int diff = -1;
      for (Map.Entry<Integer, Stack<Integer>> entry : nPairs.entrySet()) {
          int cDiff = entry.getValue().size()- incomingCount.getOrDefault(entry.getKey(), 0);
          if (cDiff > diff) {
              diff = cDiff;
              startNode = entry.getKey();
          }
      }

      GResult gArr = getLists(nPairs, startNode);
      int[][] result = new int[gArr.length][];
      int i=0;
      LNode cNode = gArr.head;
      while (cNode != null) {
          result[i++] = cNode.data;
          cNode = cNode.next;
      }
      return result;
    }
}
