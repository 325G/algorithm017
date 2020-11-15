/**
 * 使用并查集 
 * 初始化将自己列为一个圈 然后对每个人的朋友进行合并 最后统计公共群体数量
 * 
 **/
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0)
            return 0;
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M[0].length; ++j) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count();
    }
    class UnionFind {
        int count;
        int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootQ] = rootP;
                count--;
            }
        }
        public int count() {
            return count;
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