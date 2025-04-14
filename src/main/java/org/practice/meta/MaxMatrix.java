package org.practice.meta;

public class MaxMatrix {

    public long maxMatrixSum(int[][] matrix) {
        int nCount=0;
        int maxNegative = 0;
        int minPos = Integer.MAX_VALUE;

        long answer=0;

        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]<0){
                    nCount++;
                    if (maxNegative == 0 || matrix[i][j] > maxNegative){
                        answer -= maxNegative;
                        maxNegative = matrix[i][j];
                    }
                    else {
                        answer -= matrix[i][j];
                    }
                }
                else {
                    answer += matrix[i][j];
                    minPos = Math.min(minPos, matrix[i][j]);
                }
            }
        }
        if (nCount%2 == 0){
            answer -= maxNegative;
        }
        else if (minPos < Math.abs(maxNegative)){
            answer -= maxNegative+minPos;
        }
        return answer;
    }
}
