/**
 * 创建并查集
 * 额外创建边缘网格 并将边缘的网格与额外的边缘网格相连 最后统计与边缘网格相连的区域不做修改
 *
 *
 **/
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0)
            return;
        int n = board[0].length;
        int side = m * n;
        UnionFind uf = new UnionFind(m * n + 1);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    if (i == 0 ||i == m - 1 || j == 0 || j == n - 1)
                        uf.union(i * n + j, side);
                    if (i + 1 < m && board[i + 1][j] == 'O')
                        uf.union(i * n + j, (i + 1) * n + j);
                    if (j + 1 < n && board[i][j + 1] == 'O')
                        uf.union(i * n + j, (i * n + j + 1));
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && !uf.isConn(i * n + j, side))
                    board[i][j] = 'X';
            }
        }
    }
    class UnionFind {
        int[] parent;
        public boolean isConn(int p, int q) {
            return find(p) == find(q);
        }
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
            public int find(int k) {
                while (k != parent[k]) {
                    parent[k] = parent[parent[k]];
                    k = parent[k];
                }
                return k;
            }
            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP != rootQ) {
                    parent[rootQ] = rootP;
                }
            }

        
    }
}