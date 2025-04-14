package org.example.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortPathQuery {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] distances = new int[n];
        for (int i=0; i<n; i++) {
            distances[i] = i;
        }
        List<Integer>[] edges = new List[n];
        Arrays.fill(edges, new ArrayList<Integer>());
        int[] result = new int[n];
        Arrays.fill(result,1);

        for (int i=0; i<n; i++) {
            int start = queries[i][0];
            int dest = queries[i][1];
            edges[start].add(dest);

            distances[dest] = Math.min(distances[dest], distances[start]+1);
            for (int j=dest; j<n; j++){
                distances[j] = Math.min(distances[j],distances[j-1]+1);
                for (int k : edges[j]){
                    distances[k] = Math.min(distances[k],distances[j]+1);
                }
            }
            if (distances[n-1] == 1){
                break;
            }
            result[i] = distances[n-1];
        }
        return result;
    }
}
