package org.example.meta;

import java.util.*;

public class SlidingPuzzle {

    private List<List<Integer>> swapPositions = new ArrayList<>(){{
        add(Arrays.asList(1,3));
        add(Arrays.asList(0,2,4));
        add(Arrays.asList(1,5));
        add(Arrays.asList(0,4));
        add(Arrays.asList(3,1,5));
        add(Arrays.asList(2,4));
    }};

    private String getString(int[][] board){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                builder.append(board[i][j]);
            }
        }
        return builder.toString();
    }

    private boolean isGoalReached(String combination){
        return combination.equals("123450");
    }

    private String swapChars(String board, int zi, int si){
        char[] chars = board.toCharArray();
        chars[zi] = chars[si];
        chars[si] = '0';
        return new String(chars);
    }



    public int slidingPuzzle(int[][] board) {

        String firstBoard = getString(board);
        if (isGoalReached(firstBoard)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        List<String> currList = new ArrayList<>();
        currList.add(firstBoard);
        visited.add(firstBoard);

        int step = 1;
        while (!currList.isEmpty()) {
            List<String> nextList = new ArrayList<>();
            for (String s : currList) {
                int zeroIndex = s.indexOf('0');
                for (int si : swapPositions.get(zeroIndex)) {
                    String nextString = swapChars(s, zeroIndex, si);
                    if (isGoalReached(nextString)) {
                        return step;
                    } else if (!visited.contains(nextString)) {
                        nextList.add(nextString);
                        visited.add(nextString);
                    }
                }
            }
            currList = nextList;
            step++;
        }
        return -1;
    }
}
