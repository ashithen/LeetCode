package org.example.meta;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class People implements Comparable<People>{
    int height;
    int k;
    int priority;
    int sizeOnEntry;

    public People(int height, int k, int priority, int sizeOnEntry){
        this.height = height;
        this.k = k;
        this.priority = priority;
        this.sizeOnEntry = sizeOnEntry;
    }

    @Override
    public int compareTo(People o) {
        if (this.priority == o.priority){
            return this.height - o.height;
        }
        else {
            return this.priority - o.priority;
        }
    }
}
public class PeopleHeightSort {

    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<People> pq = new PriorityQueue<>();
        Arrays.sort(people, (a,b)->(a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]));
        List<int[]> output = new ArrayList<>();
        for (int[] p : people){
            while (!pq.isEmpty()){
                People pp = pq.peek();
                if (output.size()-pp.sizeOnEntry == pp.k){
                    pq.poll();
                    output.add(new int[]{pp.height, pp.k});
                }
                else {
                    break;
                }
            }
            if (output.size() == p[1]){
                output.add(p);
            }
            else {
                People pqP = new People(p[0],p[1],p[1]+ output.size(), output.size());
                pq.add(pqP);
            }
        }
        while (!pq.isEmpty()){
            People pp = pq.poll();
            output.add(new int[]{pp.height, pp.k});
        }
        int[][] res = new int[output.size()][2];
        for (int i=0; i<output.size(); i++){
            res[i][0] = output.get(i)[0];
            res[i][1] = output.get(i)[1];
        }
        return res;
    }
}
