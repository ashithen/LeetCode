package org.practice.meta;

public class GuardCell {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];
        for (int[] wall : walls) {
            matrix[wall[0]][wall[1]] = 2;
        }
        for (int[] guard : guards) {
            for (int i=guard[0]; i<m; i++){
                if (matrix[i][guard[1]] == 2 || matrix[i][guard[1]] == 1){
                    break;
                }
                matrix[i][guard[1]] = 1;
            }
            for (int i=guard[0]-1; i>=0; i--){
                if (matrix[i][guard[1]] == 2 || matrix[i][guard[1]] == 1){
                    break;
                }
//                System.out.printf("%d %d\n",i,guard[1]);
                matrix[i][guard[1]] = 1;
            }
            for (int i=guard[1]; i<n; i++){
                if (matrix[guard[0]][i] == 2 || matrix[guard[0]][i] == -1){
                    break;
                }
                matrix[guard[0]][i] = -1;
            }
            for (int i=guard[1]-1; i>=0; i--){
                if (matrix[guard[0]][i] == 2 || matrix[guard[0]][i] == -1){
                    break;
                }
                matrix[guard[0]][i] = -1;
            }
        }
        int ans=0;
        for (int i=0;i< m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]==0){

                    ans++;
                }
            }
        }
        return ans;
    }
}
