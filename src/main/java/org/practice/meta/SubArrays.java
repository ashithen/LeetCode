package org.practice.meta;

public class SubArrays {


    int[] countSubarrays(int[] arr) {
        // Write your code here
        int n = arr.length;
        int[] lC = new int[n];
        for(int i=1; i<n; i++){
            int p = i-1;
            while(p >= 0 && arr[p] < arr[i]){
                p -= 1+lC[p];
            }
            lC[i] = i-p-1;
        }

        int[] rC = new int[n];
        for(int i=n-2; i>=0; i--){
            int p = i+1;
            while(p < n && arr[p] < arr[i]){
                p += 1+rC[p];
            }
            rC[i] = p-i-1;
        }

        for(int i=0; i<n; i++){
            rC[i] += lC[i]+1;
        }

        return rC;
    }



    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }
    public void run() {
        int[] test_1 = {3, 4, 1, 6, 2};
        int[] expected_1 = {1, 3, 1, 5, 1};
        int[] output_1 = countSubarrays(test_1);
        check(expected_1, output_1);

        int[] test_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {1, 2, 6, 1, 3, 1};
        int[] output_2 = countSubarrays(test_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new SubArrays().run();
    }
}
