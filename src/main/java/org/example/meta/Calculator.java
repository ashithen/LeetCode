package org.example.meta;

import java.util.*;

public class Calculator {

    private LinkedList<String> getNumList(String s){
        LinkedList<String> nList = new LinkedList<>();
        StringBuilder num = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c == ' '){
                continue;
            }
            if (Character.isDigit(c)){
                num.append(c);
            }
            else {
                nList.add(num.toString());
                num.setLength(0);
                nList.add(Character.toString(c));
            }
        }
        nList.add(num.toString());
        return nList;
    }

    private int calc(int a, int b, String op){
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return a / b;
        }
    }

    private void operate(LinkedList<String> numList, String op1, String op2){
        int i=1;
        while (i<numList.size()){
            String op = numList.get(i);
            if (op.equals(op1) || op.equals(op2)){
                int a = Integer.parseInt(numList.get(i-1));
                int b = Integer.parseInt(numList.get(i+1));
                int ans = this.calc(a,b,op);
                numList.remove(i-1);
                numList.remove(i-1);
                numList.remove(i-1);
                numList.add(i-1,String.valueOf(ans));
            }
            else {
                i++;
            }
        }
    }

    public int calculate(String s) {
        LinkedList<String> numList = this.getNumList(s);
        this.operate(numList, "*","/");
        this.operate(numList,"+","-");
//        System.out.println(numList.size());
        return Integer.parseInt(numList.get(0));
    }

    public static void main(String[] args) {
        String eval = "3+2*2";
        System.out.println(new Calculator().calculate(eval));
    }
}
