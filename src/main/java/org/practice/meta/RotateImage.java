package org.practice.meta;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] transpose=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                transpose[j][i]=matrix[i][j];
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j]=transpose[i][n-1-j];
            }
        }
    }
}
