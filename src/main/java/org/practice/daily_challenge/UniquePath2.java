package org.practice.daily_challenge;

public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];
        dp[m][n-1] = 1;

        for (int i=m-1; i>=0; i--){
            for (int j=n-1; j >= 0; j--){
                if (obstacleGrid[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
