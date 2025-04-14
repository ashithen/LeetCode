package org.practice.daily_challenge;

import java.util.*;

public class CriticalConnection {

    private Map<Integer, Set<Integer>> graph;
    private int[] parentStep;
    private int[] visitStep;
    private int stepCount;

    private Map<Integer, Set<Integer>> buildGraph(int n, List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
        return graph;
    }

    private int dfs(int node, int prevNode){
        if (this.parentStep[node] >= 0){
            return this.parentStep[node];
        }
        this.stepCount++;
        this.visitStep[node] = this.stepCount;
        this.parentStep[node] = this.stepCount;
        for (int nextNode : this.graph.get(node)){
            if (nextNode == prevNode){
                continue;
            }
            this.parentStep[node] = Math.min(this.parentStep[node], this.dfs(nextNode, node));
        }
        return this.parentStep[node];
    }

    private int getStep(int node){
        if (this.visitStep[node] == this.parentStep[node]){
            return this.visitStep[node];
        }
        else {
            this.parentStep[node] = this.getStep(this.parentStep[node]);
            return this.parentStep[node];
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.graph = this.buildGraph(n, connections);
        this.parentStep = new int[n];
        Arrays.fill(this.parentStep, -1);
        this.visitStep = new int[n];
        Arrays.fill(this.visitStep, -1);
        this.stepCount = -1;
        this.dfs(0, -1);

        List<List<Integer>> output = new ArrayList<>();
        for (List<Integer> connection : connections){
            if (this.getStep(connection.get(0)) != this.getStep(connection.get(1))){
                output.add(connection);
            }
        }
        System.out.println(Arrays.toString(this.parentStep));
        return output;
    }

    public static void main(String[] args) {
        int[][] values = {
                {0, 1},
                {1, 2},
                {2, 0},
                {1, 3},
                {3, 4},
                {4, 5},
                {5, 3}
        };
        List<List<Integer>> listOfLists = new ArrayList<>();

        for (int[] innerArray : values) {
            List<Integer> innerList = new ArrayList<>();
            for (int value : innerArray) {
                innerList.add(value);
            }
            listOfLists.add(innerList);
        }
        int n = 6;
        System.out.println(new CriticalConnection().criticalConnections(n, listOfLists));
    }
}
