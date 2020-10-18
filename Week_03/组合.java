/**
 * 
 * 采用回溯思想，每次对元素进行选择或者不选择抉择
 * 剪枝：如果已选择元素与待选择元素无法凑成目标个数则不继续抉择
 *
 **/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, k, 1, ans, new ArrayList<>());
        return ans;
    }
    public void dfs(int n, int k, int idx, List<List<Integer>> ans, List<Integer> temp) {
        if (temp.size() + (n - idx + 1) < k) return;
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        dfs(n, k , idx + 1, ans, temp);
        temp.add(idx);
        dfs(n, k, idx + 1, ans, temp);
        temp.remove(temp.size() - 1);
    }
}