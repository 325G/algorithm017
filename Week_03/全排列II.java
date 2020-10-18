/**
 *
 * 和全排列的思想类似，需要注意的是相同数字相同位置只能排列一次 如 1（idx1）、2、 1（idx2） 如果再出现1（idx2）、2、1（idx1） 算做一种
 * 剪枝去重的方式 为对原排列数据做排序使相同的数字在一起，对于相同的数字，后面索引的数字如果选择择前面的必须要选择，如： 1（idx1）、2、 1（idx2） 
 * 如果idx2位置的1做选择加入答案则idx1位置的1必须已经被选择
 *
 **/
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] valid;
    public List<List<Integer>> permuteUnique(int[] nums) {
        valid = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(0, nums);
        return ans;
    }
    public void dfs(int idx, int[] nums){
        if (idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return; 
        }
        for (int i = 0;i < nums.length; ++i){
            if (valid[i] || (i > 0 && nums[i] == nums[i - 1] && !valid[i - 1]))
                continue;
            valid[i] = true;
            temp.add(nums[i]);
            dfs(idx + 1, nums);
            valid[i] = false;
            temp.remove(idx);

        }
    }
}