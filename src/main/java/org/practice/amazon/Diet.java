package org.practice.amazon;

public class Diet {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        long total = 0;
        int answer = 0;
        for (int i=0; i<k; i++){
            total += calories[i];
        }
        if (total < lower){
            answer--;
        }
        else if (total > upper){
            answer++;
        }
        for (int i=k; i<calories.length; i++){
            total -= calories[i-k];
            total += calories[i];
            if (total < lower){
                answer--;
            }
            else if (total > upper){
                answer++;
            }
        }
        return answer;
    }
}
