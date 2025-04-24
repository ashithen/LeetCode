package org.practice.daily_challenge;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC781 {

    public int numRabbits(int[] answers) {
        Map<Integer, Long> cMap = IntStream.of(answers).boxed().collect(
                Collectors.groupingBy(n -> n + 1, Collectors.counting())
        );
        int ans = 0;
        for (Map.Entry<Integer, Long> e : cMap.entrySet()) {
            int k = e.getKey();
            int v = e.getValue().intValue();
            int r = k%v;
            v += r;
            ans += v;
        }
        return  ans;
    }
}
