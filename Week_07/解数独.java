class Solution {
    boolean[][] line = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];
    List<int[]> spaces = new ArrayList<>();
    boolean valid = false;
    public void solveSudoku(char[][] board) {
        for (int i = 0;i < 9; ++i) {
            for (int j = 0;j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }else{
                    int num = board[i][j] - '0' - 1;
                    line[i][num] = column[j][num] = block[i / 3][j / 3][num] = true;
                }
            }
        }
        dfs(0, board);
    }

    public void dfs(int idx, char[][] board){
        if (idx == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(idx);
        int i = space[0], j = space[1];
        for (int num = 0;num < 9 && !valid; ++num) {
            if(!line[i][num] && !column[j][num] && !block[i /3][j / 3][num]){
                line[i][num] = column[j][num] = block[i / 3][j / 3][num] = true;
                board[i][j] = (char)(num + '0' + 1);
                dfs(idx + 1, board);
                line[i][num] = column[j][num] = block[i / 3][j / 3][num] = false;
            }
        }
    }
}