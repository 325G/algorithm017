/**
 *
 * 二分法
 * 取中点 判断递增序列在左边还是在右边 （根据递增性能够判断目标数是否在该序列中）
 * 根据判断递增序列中是否存在目标数 选择检索起始位置和终止位置
 * 
 *
 **/
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
           int mid = (hi - lo) / 2 + lo;
           if (nums[mid] == target)
            return mid;
           if (nums[mid] >= nums[lo]) {
               if (target >= nums[lo] && target < nums[mid]) {
                   hi = mid - 1;
               } else {
                   lo = mid + 1;
               }
           } else {
               if (target > nums[mid] && target <= nums[hi]) {
                   lo = mid + 1;
               } else {
                   hi = mid - 1;
               }
           }
        }
        return -1;
    }
}