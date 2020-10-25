/**
 *
 * 从后向前贪心算法
 * 起始目标点选在最后，依次检索能够跳跃过目标点的位置，如果能够到达起始位置则可以从起始跳跃到最后
 * 从最后一个位置起向前检索，如果存在一个位置可以跳跃到最后则选取该点为目标点，继续向前检索能够到达该点的位置。
 *
 **/
class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] + i >= last)
                last = i;
        }
        return last == 0;
    }
}