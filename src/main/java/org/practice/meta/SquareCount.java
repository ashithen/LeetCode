package org.practice.meta;

public class SquareCount {

    public int countSquares(int[][] matrix) {
        int[][] hCt = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int ct = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                ct = matrix[i][j] == 1 ? ct + 1 : 0;
                hCt[i][j] = ct;
            }
        }
        int[][] vCt = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int ct = 0;
            for (int i = 0; i < matrix.length; i++) {
                ct = matrix[i][j] == 1 ? ct + 1 : 0;
                vCt[i][j] = ct;
            }
        }
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                total++;
                int d = 1;
                while ((i + d) < matrix.length && (j + d) < matrix[0].length
                        && hCt[i + d][j + d] >= (d + 1) && vCt[i + d][j + d] >= (d + 1)) {
                    total++;
                    d++;
                }
            }
        }
        return total;
    }
}
