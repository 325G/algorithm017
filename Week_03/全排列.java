/**
 *
 * 换个角度即初始化一个和待排序组合数组一样长度的数组 每个格子的数字从待组合的数组中选一个，且选过的数字不能在选择；
 * 使用boolean类型的数组记录已经选过的元素下标，然后依次尝试填入的数字
 *
 *
 **/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }
    public void dfs(int[] nums, int idx, List<List<Integer>> ans, List<Integer> temp, boolean[] valid) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (valid[i]) continue;
            temp.add(nums[i]);
            valid[i] = true;
            dfs (nums, idx + 1, ans, temp, valid);
            temp.remove(idx);
            valid[i] = false;
        }
    }
}