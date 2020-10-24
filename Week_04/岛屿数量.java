/**
 * 从00位置开始遍历，当遇到陆地（1）时，陆地数加一并把陆地标记改为水（0）然后使用深度优先搜索继续查找相连陆地
 *
 *
 **/
class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        if (grid == null || grid.length == 0)
            return ans;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }
    public void dfs(int line, int column, char[][] grid) {
        if (line < 0 || line >= grid.length || column < 0 || column >= grid[0].length || grid[line][column] == '0')
            return;
        grid[line][column] = '0';
        dfs(line + 1, column, grid);
        dfs(line - 1, column, grid);
        dfs(line, column + 1, grid);
        dfs(line, column - 1, grid);
    }
}