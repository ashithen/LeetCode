package org.example.meta;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class KClose {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey().compareTo(a.getKey()));
        for (int i=0; i<points.length; i++){
            int[] point = points[i];
            double val = Math.pow(point[0],2);
            val += Math.pow(point[1],2);
            if (pq.size() == k && pq.peek().getKey() > val){
                pq.poll();
            }
            pq.add(new Pair<>(val,i));
        }
        int[][] result = new int[k][2];
        int i=0;
        for (Pair<Double, Integer> pair : pq){
            result[i++] = points[pair.getValue()];
        }
        return result;
    }
}
