class Solution {
    public int totalNQueens(int n) {
        return dfs(n, 0, 0, 0, 0);
    }
    public int dfs(int n, int row, int cols, int pie, int na) {
        if (n == row)
            return 1;
        int aliPosition = ((1 << n) - 1) & (~(cols | pie | na));
        int count = 0;
        while (aliPosition != 0) {
            int position = aliPosition & (-aliPosition);
            aliPosition &= (aliPosition - 1);
            count += dfs(n, row + 1, cols | position, (pie | position) << 1, (na | position) >> 1);
        }
        return count;
    }
}