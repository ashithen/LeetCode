package org.practice.meta;

public class BooleanOperations {

    private char[] chars;
    private int index;
    private boolean isOperator(char c){
        return c == '&' || c == '|' || c=='!';
    }

    private boolean parseBool(char c){
        return c == 't';
    }

    private boolean doOp(){
        char c = chars[index];
        index++;
        if (c == '&'){
            return this.andOp();
        } else if (c == '|') {
            return this.orOp();
        }
        else {
            return this.notOp();
        }
    }

    private boolean notOp(){
//        System.out.printf("NOT %d\n",index);
        if (chars[index] == '('){
            index++;
        }
        boolean res;
        if (isOperator(chars[index])){
            res = doOp();
        }
        else {
            res = parseBool(chars[index]);
            index++;
        }
        if (index < chars.length && chars[index] == ')'){
            index++;
        }
        return !res;
    }

    private boolean orOp(){
        if (chars[index] == '('){
            index++;
        }
        boolean result = false;
        while (chars[index] != ')'){
//            System.out.printf("OR %d\n",index);
            if (chars[index] == ','){
                index++;
            }
            if (isOperator(chars[index])){
                result = doOp();
            }
            else {
                result = parseBool(chars[index]);
                index++;
            }
            if (result){
                skipTillEnd();
                break;
            }
        }
        if (index < chars.length && chars[index] == ')'){
            index++;
        }
        return result;

    }

    private boolean andOp(){
        if (chars[index] == '('){
            index++;
        }
        boolean result = true;
        while (chars[index] != ')'){
//            System.out.printf("AND %d\n",index);
            if (chars[index] == ','){
                index++;
            }
            if (isOperator(chars[index])){
                result = doOp();
            }
            else{
                result = parseBool(chars[index]);
                index++;
            }
            if (!result){
                skipTillEnd();
                break;
            }
        }
        if (index < chars.length && chars[index] == ')'){
            index++;
        }
        return result;
    }

    private void skipTillEnd(){
        int count = 0;
        while (count != 0 || chars[index] != ')'){
            if (chars[index] == '('){
                count++;
            }
            else if (chars[index] == ')'){
                count--;
            }
            index++;
        }
    }

    public boolean parseBoolExpr(String expression) {
        this.chars = expression.toCharArray();
        this.index = 0;
        if (isOperator(chars[index])){
            return doOp();
        }
        else {
            return parseBool(chars[index]);
        }
    }


    public static void main(String[] args) {
        String exp = "&(!(f),|(&(f,t),&(t,t),|(t,f)))";
        System.out.println(new BooleanOperations().parseBoolExpr(exp));
    }

}
