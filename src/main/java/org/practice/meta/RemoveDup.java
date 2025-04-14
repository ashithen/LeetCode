package org.practice.meta;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveDup {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (stack.isEmpty()){
                stack.add(c);
            } else if (c == stack.peek()) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {

    }
}
