package org.practice.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Asteroid {

    public int[] asteroidCollision(int[] asteroids) {

        List<Integer> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids){
            if (ast > 0){
                stack.push(ast);
            }
            else {
                while (!stack.isEmpty() && stack.peek() < Math.abs(ast)){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    output.add(ast);
                } else if (stack.peek() == Math.abs(ast)) {
                    stack.pop();
                }
            }
        }
        int[] result = new int[output.size()+stack.size()];
        int i=0;
        for (int n : output){
            result[i++] = n;
        }
        for (int n : stack){
            result[i++] = n;
        }
        return result;
    }

}
