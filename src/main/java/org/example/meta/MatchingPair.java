package org.example.meta;

import java.util.HashSet;
import java.util.Set;

public class MatchingPair {

    int matchingPairs(String s, String t) {
        // Write your code here
        int unMatchedCount = 0;
        boolean swapFound = false;
        Set<Integer> unmatchedSet = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == t.charAt(i)){
                continue;
            }
            unMatchedCount++;

            if(!swapFound){
                int d = s.charAt(i)-t.charAt(i);
                if(unmatchedSet.contains(-d)){
                    swapFound = true;
                }
                else{
                    unmatchedSet.add(d);
                }
            }
        }

        int numMatch = s.length()-unMatchedCount;
        if(swapFound){
            numMatch += 2;
        }
        else if(unMatchedCount < 2){
            numMatch -= 2 - unMatchedCount;
        }

        return numMatch;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        int output_1 = matchingPairs(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);

        String s_3 = "abcde";
        String t_3 = "abcdf";
        int expected_3 = 3;
        int output_3 = matchingPairs(s_3, t_3);
        check(expected_3, output_3);

        String s_4 = "abcde";
        String t_4 = "abcdf";
        int expected_4 = 3;
        int output_4 = matchingPairs(s_4, t_4);
        check(expected_4, output_4);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new MatchingPair().run();
    }
}
