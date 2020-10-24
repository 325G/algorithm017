/**
 *
 * 使用两个数组代表下次搜索方位
 * 如果挖出的位置为地雷则改变值为X，结束
 * 否则对八个方位进行一次检索，如果存在地雷则修改挖出位为地雷数
 * 如果周围没有地雷则修改为B标记然后对8个方位依次进行深度优先搜索
 *
 **/
class Solution {
    int[] x = {-1, 1, 0, 0, 1, -1, 1, -1};
    int[] y = {0, 0, 1, -1, 1, -1, -1, 1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];        
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            
        } else {
            dfs(i ,j, board);
        }

        return board;  

    }
    public void dfs(int i, int j, char[][] board) {
        //if (board[i][j] == 'E') {
            int num = 0;
            for (int k = 0; k < 8; ++k) {
                
                int curX = i + x[k];
                int curY = j + y[k];
                if (curX < 0 || curX >= board.length || curY < 0 || curY >= board[0].length)
                    continue;
                if (board[curX][curY] == 'M')
                    num ++;
            }
            if (num > 0) {
                board[i][j] = (char) (num + '0');
                return;
            } else {
                board[i][j] = 'B';
                for (int k = 0; k < 8; ++k) {
                    int curX = i + x[k];
                    int curY = j + y[k];
                    if (curX < 0 || curX >= board.length || curY < 0 || curY >= board[0].length || board[curX][curY] != 'E')
                    continue;
                    dfs(curX, curY, board);
                }
            }
        //}
    }
 }