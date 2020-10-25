/**
 *
 * 前提一定可以跳跃到最后，因此跳跃段为起始到终点前一个位置
 * 相当于对跳跃分段 每次段最大即可获取到最小次数
 * 起始段为起始位置跳跃最远位置，再第一段中寻找最远跳跃位置作为第二段终点 依次进行直到跳跃到最后
 *
 **/
class Solution {
    public int jump(int[] nums) {
        int end = 0, ans = 0, maxPos = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }
}