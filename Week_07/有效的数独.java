class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] line = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][][] block = new boolean[3][3][9];
        for (int i = 0;i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    if (line[i][num] || column[j][num] || block[i / 3][j / 3][num])
                        return false;
                    line[i][num] = column[j][num] = block[i / 3][j / 3][num] = true;
                }
            }
        }
        return true;
    }
}