package org.practice.meta;

import java.util.*;
// Add any extra import statements you may need here

class Stack<T>{
    private final List<T> elementList;

    public Stack(){
        this.elementList = new ArrayList<>();
    }

    public void add(T element){
        this.elementList.add(element);
    }

    public boolean isEmpty(){
        return this.elementList.isEmpty();
    }

    public Optional<T> pop(){
        if(this.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(this.elementList.remove(this.elementList.size()-1));
    }
}

class Parantheses {
    // Add any helper functions you may need here


    boolean isBalanced(String s) {
        // Write your code here
        List<Character> openB = List.of('(','[','{');
        List<Character> closeB = List.of(')',']','}');
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(openB.contains(c)){
                stack.add(c);
            }
            else if(closeB.contains(c)){
                System.out.println(c);
                Optional<Character> prev = stack.pop();
                if(prev.isEmpty() ||
                        closeB.indexOf(c) != openB.indexOf(prev.get())){
                    return false;
                }
            }
        }



        return stack.isEmpty();
    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.set(0,nums.get(0)+16);
        System.out.println(nums.get(0));
    }
}
