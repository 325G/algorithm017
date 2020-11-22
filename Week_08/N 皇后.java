/**
 * 1 << n -1 将n个皇后二进制都设置为1 如8皇后则为 000...11111111
 * cols pie na 1的位置为标记为占用位， cols | pie | na 按位或运算获取所有占用位，取反后得到所有1标记为空余位，通过按位与(1 << n) - 1 
 * 得到空余位置二进制表示方式如：0000... 11001110 目的为除n位置的高位都设置为0.
 * position = aliPosition & （-aliPosition）得到最低位为1的表示方式代表可以放置皇后位置，aliPosition & （aliPosition - 
 *  1）去除最低位1（因为该位置已经标记放置皇后）
 *  cols | position, (pie | position) << 1, (na | position) >> 1 分别做与运算 代表三个记录位已经放置皇后 pie na位斜位需要左右移1
 **/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        dfs(n, 0, 0, 0, 0, ans, new int[n]);
        return ans;
    }

    public void dfs(int n, int row, int cols, int pie ,int na, List<List<String>> ans, int[] queens) {
        if (row == n) {
            ans.add(genAns(queens));
            return;
        }
        int aliPosition = ((1 << n) - 1) & (~(cols | pie | na));
        while (aliPosition != 0) {
            int position = aliPosition & (-aliPosition);
            aliPosition &= aliPosition - 1;
            queens[row] = Integer.bitCount(position - 1);
            dfs(n, row + 1, cols | position, (pie | position) << 1, (na | position) >> 1, ans, queens);
            //queens[row] = -1;
        }
    }
    public List<String> genAns(int[] queens) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < queens.length; ++i) {
            char[] row = new char[queens.length];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            result.add(String.valueOf(row));
        }
        return result;
    }
}