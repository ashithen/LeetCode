package org.practice;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MinFuel {

    private int seats;
    private Map<Integer, Set<Integer>> graph;

    private Map<Integer, Set<Integer>> initialiseGraph(int[][] roads){
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] road : roads){
            int i = road[0];
            int j = road[1];
            if (!graph.containsKey(i)){
                graph.put(i,new HashSet<>());
            }
            graph.get(i).add(j);
            if (!graph.containsKey(j)){
                graph.put(j, new HashSet<>());
            }
            graph.get(j).add(i);
        }

        return graph;
    }

    private Pair<Integer, Long> getPersonCost(int node){
        int person = 1;
        long cost = 0;

        for (int nextNode : this.graph.get(node)){
            this.graph.get(nextNode).remove(node);
            Pair<Integer, Long> result = this.getPersonCost(nextNode);
            cost += (long) Math.ceil((double) result.getKey() / this.seats) + result.getValue();
            person += result.getKey();
        }
        return new Pair<>(person, cost);
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0){
            return 0;
        }
        this.seats = seats;
        this.graph = this.initialiseGraph(roads);
        return this.getPersonCost(0).getValue();
    }

    public static void main(String[] args) {
        int[][] roads = {
                {3, 1},
                {3, 2},
                {1, 0},
                {0, 4},
                {0, 5},
                {4, 6}
        };
        int seats = 2;

        System.out.println(new MinFuel().minimumFuelCost(roads, seats));
    }
}
