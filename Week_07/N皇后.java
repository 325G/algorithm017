class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        dfs(n, 0, new int[n], ans, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return ans;
    }
    public void dfs(int n, int row, int[] queens, List<List<String>> ans, Set<Integer> column, Set<Integer> diags1, Set<Integer> diags2) {
        if (row == n) {
            ans.add(genAns(queens));
            return;
        }
        for (int i = 0; i < n; ++i) {
            int diag1 = row + i, diag2 = row - i;
            if (column.contains(i) || diags1.contains(diag1) || diags2.contains(diag2))
                continue;
            column.add(i);
            queens[row] = i;
            diags1.add(diag1);
            diags2.add(diag2);
            dfs(n, row + 1, queens, ans, column, diags1, diags2);
            column.remove(i);
            queens[row] = -1;
            diags1.remove(diag1);
            diags2.remove(diag2);
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