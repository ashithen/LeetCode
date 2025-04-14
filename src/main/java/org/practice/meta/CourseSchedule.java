package org.practice.meta;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    private boolean[] isVisited;
    private List<List<Integer>> edges;
    private boolean[] pathArr;

    private boolean traverse(int node){
        if (pathArr[node]){
            return false;
        }
        if (isVisited[node]){
            return true;
        }
        isVisited[node] = true;
        pathArr[node] = true;
        for (int next : edges.get(node)){
            if (!traverse(next)){
                return false;
            }
        }
        pathArr[node] = false;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.isVisited = new boolean[numCourses];
        edges = new ArrayList<>();
        pathArr = new boolean[numCourses];
        for (int i=0; i<numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for (int[] path : prerequisites){
            edges.get(path[0]).add(path[1]);
        }

        for (int i=0; i<numCourses; i++){
            if (!traverse(i)){
                return false;
            }
        }
        return true;
    }
}
