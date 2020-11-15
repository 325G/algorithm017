/**
 * 递归备忘录方式剪枝重复计算
 *
 **/
class Solution {
    int[] cache;
    public int climbStairs(int n) {
        
        cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        return dfs(n);
    }
    public int dfs(int n) {
        if (cache[n] != 0)
         return cache[n];
        cache[n] = dfs(n - 1) + dfs(n - 2);
        return cache[n];
    }
}