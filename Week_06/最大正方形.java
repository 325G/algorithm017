/**
 *
 * 子问题- m-n位置可以看做左上方 左方 上方构成的正方形额外添加的边，那么m-n位置可构成的正方形为 上方 左方 左上方可构成最大正方形最小的一个边长加一
 * dp数组 int[][] m n位置可以构成的最大正方形
 * dp方程 dp[m][n] = 1, m == 1 || n == 1; dp[m][n] = min(dp[m - 1][n - 1], dp[m - 1][n], dp[m][n - 1]) + 1;
 *
 *
 **/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
                maxSide = Math.max(dp[i][j], maxSide);
            }
        }
        return maxSide * maxSide;
    }
}