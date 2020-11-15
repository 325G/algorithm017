/**
 * 递归 剪枝 左括号不能超过总数对数 右括号不能超过左括号
 *
 **/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0)
            return ans;
        dfs(0 , 0, n , ans, "");
        return ans;
    }
    public void dfs(int left, int right, int n, List<String> ans, String temp) {
        if (left == n && right == n) {
            ans.add(temp);
            return;
        }
        if (left < n)
            dfs(left + 1, right, n, ans, temp + "(");
        if (right < left)
            dfs(left, right + 1, n, ans, temp + ")");
    }
}