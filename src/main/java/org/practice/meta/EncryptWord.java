package org.practice.meta;

// Add any extra import statements you may need here


class EncryptWord {

    // Add any helper functions you may need here

    private void encrypt(char[] sArr,int sI,int eI, int oI, char[] out){
//        System.out.printf("s: %d, e: %d, o:%d\n",sI,eI,oI);
        if(eI-sI <= 2) {
            if (eI - sI == 2) {
                out[oI] = sArr[sI];
                out[oI + 1] = sArr[sI + 1];
            } else if (eI - sI == 1) {
                out[oI] = sArr[sI];
            }
            return;
        }

        int mid = (sI+eI-1)/2;
        out[oI] = sArr[mid];
        this.encrypt(sArr, sI, mid, oI+1, out);
        this.encrypt(sArr, mid+1, eI, oI+1+mid-sI, out);


    }


    String findEncryptedWord(String s) {
        // Write your code here
        char[] sArr = s.toCharArray();
        char[] out = new char[sArr.length];
        this.encrypt(sArr, 0, sArr.length, 0, out);
        return new String(out);
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String s_1 = "abc";
        String expected_1 = "bac";
        String output_1 = findEncryptedWord(s_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String expected_2 = "bacd";
        String output_2 = findEncryptedWord(s_2);
        check(expected_2, output_2);

        String s_3 = "facebook";
        String expected_3 = "eafcobok";
        String output_3 = findEncryptedWord(s_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new EncryptWord().run();
        System.out.println(new EncryptWord().findEncryptedWord("db  vfhdchjvjhdvcjhvdjcvj dvcjhdhcvj  ashdvchjvdjvcjsvdcwy  quytwu"));
    }
}
