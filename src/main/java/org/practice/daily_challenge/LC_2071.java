package org.practice.daily_challenge;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LC_2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int w : workers) {
            workerMap.put(w, workerMap.getOrDefault(w, 0) + 1);
        }
        int ans = 0;
        int taskIndex = tasks.length - 1;
        while (pills > 0 && taskIndex >= 0 && !workerMap.isEmpty()) {
            int task = tasks[taskIndex];
            Map.Entry<Integer, Integer> wEntry = workerMap.ceilingEntry(task - strength);
            if (wEntry == null) {
                taskIndex--;
                continue;
            }
            if (wEntry.getKey() < task) {
                pills--;
            }
            if (wEntry.getValue() == 1) {
                workerMap.remove(wEntry.getKey());
            }
            else {
                workerMap.put(wEntry.getKey(), wEntry.getValue() - 1);
            }
            ans++;
            taskIndex--;
        }
        int i = 0;
        for (Map.Entry<Integer,Integer> wEntry : workerMap.entrySet()) {
            if (i > taskIndex) {
                break;
            }
            int worker = wEntry.getKey();
            for (int j=0; j<wEntry.getValue() && i<=taskIndex; j++){
                if (tasks[i] <= worker) {
                    ans++;
                    i++;
                }
                else {
                    break;
                }
            }
        }
        return ans;
    }
}
