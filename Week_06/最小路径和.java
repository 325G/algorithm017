/**
 *
 * 子问题- 某网格只能由上方或者左方移动过来，从终点开始考虑，路径最小值取左方格与上方格较小的一个，并将最小值方格作为终点形成子问题
 * dp数组- int[][]  代表m n位置方格作为终点的最小值
 * dp方程- dp[0][n] = dp[0][n - 1] + grid[0][n] m = 0; dp[m][0] = dp[m - 1][0] + grid[m][0] n = 0; dp[m][n] = min(dp[m - 1][n], dp[m][n - 1]) m,n >= 1;
 *
 *
 **/
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n  = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; ++i) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}