/**
 *
 * 创建并查集
 * 初始化每个网格为一个岛屿 然后合并每个网格陆地区域
 *
 **/
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        int w = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    if (i + 1 < m && grid[i + 1][j] == '1')
                        uf.union(i * n + j, (i + 1) * n + j);
                    if (j + 1 < n && grid[i][j + 1] == '1')
                        uf.union(i * n + j, i * n + j + 1);
                } else {
                    w++;
                }
            }
        }
        return uf.count() - w;
    }
    class UnionFind {
        int[] parent;
        int count;
        public int count() {
            return count;
        }
        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }


        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                count--;
            }
        }
        public int find(int k) {
            while (k != parent[k]) {
                parent[k] = parent[parent[k]];
                k = parent[k];
            
            }
            return k;
        }
    }
}