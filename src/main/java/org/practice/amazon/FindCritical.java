package org.practice.amazon;

import java.util.*;

public class FindCritical {
    List<Integer>[] edgesMap;
    List<List<Integer>> criticalConnections;
    Set<Integer>[] processedEdges;

    private List<Integer>[] getEdgesMap(int n, List<List<Integer>> connections){
        List<Integer>[] edgesMap = new List[n];
        for (int i = 0; i < n; i++) {
            edgesMap[i] = new ArrayList<Integer>();
        }
        for (List<Integer> connection : connections) {
            edgesMap[connection.get(0)].add(connection.get(1));
            edgesMap[connection.get(1)].add(connection.get(0));
        }
        return edgesMap;
    }

    private Set<Integer> dfs(int cnode, boolean[] pVisited){
        Set<Integer> cycleNode = new HashSet<>();
        pVisited[cnode] = true;
        for (int nnode : edgesMap[cnode]) {
            if (processedEdges[cnode].contains(nnode)) {
                continue;
            }
            processedEdges[cnode].add(nnode);
            processedEdges[nnode].add(cnode);
            if (pVisited[nnode]) {
                cycleNode.add(nnode);
                continue;
            }
            Set<Integer> nextCycle = dfs(nnode, pVisited);
            boolean isCyclic = false;
            for (int node : nextCycle) {
                if (pVisited[node]) {
                    cycleNode.add(node);
                    isCyclic = true;
                }
            }
            if (!isCyclic) {
                criticalConnections.add(Arrays.asList(cnode, nnode));
            }
        }
        pVisited[cnode] = false;
        return cycleNode;
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        edgesMap = getEdgesMap(n, connections);
        criticalConnections = new ArrayList<>();
        boolean[] visited = new boolean[n];
        processedEdges = new Set[n];
        for (int i = 0; i < n; i++) {
            processedEdges[i] = new HashSet<>();
        }
        this.dfs(0, visited);
        return criticalConnections;
    }
}
