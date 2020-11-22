/**
 * 归并排序， 排序过程中统计翻转对数量
 * 合并排序时 左区间和右区间已经有序（从小到大），翻转对下标从左区间起始位置开始，如果该位置数字小于或等于2倍右区间比较数字，则移动一位；因为左区间从小到大有序
 * 因此当当前左区间数字大于右区间二倍当前数字，那么左区间后序的数字mid - i + 1个也会大于当前右区间2倍当前数字；同理右区间2倍当前数字如果大于当前左区间数字那么
 * 右区间当前2倍数字也大于左区间起始位置到当前位置的数字；
 *
 *
 **/
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    public int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return 0;
        int mid = (hi - lo) / 2 + lo;
        int count = mergeSort(nums, lo, mid) + mergeSort(nums, mid + 1, hi);
        int[] temp = new int[hi - lo + 1];
        int i = lo, t = lo, c = 0;
        for (int j = mid + 1; j <= hi; ++j, ++c) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j])
                ++i;
            while (t <= mid && nums[t] < nums[j])
                temp[c++] = nums[t++];
            temp[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid)
            temp[c++] = nums[t++];
        System.arraycopy(temp, 0, nums, lo, hi - lo + 1);
        return count;
    }
}