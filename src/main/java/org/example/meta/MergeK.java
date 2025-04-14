package org.example.meta;


import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class MergeK {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(a -> a.val));
        for (ListNode node : lists){
            if (node != null){
                pq.add(node);
            }
        }
        ListNode head = null;
        ListNode curr = null;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            if (node.next != null){
                pq.add(node.next);
            }
            if (curr == null){
                head = node;
                curr = node;
            }
            else {
                curr.next = node;
                curr = node;
            }
        }
        return head;
    }
}
