/**
 *
 *	遍历数组使用使用HashMap记录之前出现的数字
 *  遍历过程中使用将目标值与当前值取差值，并在之前的缓存记录中查找是否存在差值
 *  
 *
 **/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int cur = target - nums[i];
            if (cache.containsKey(cur)) return new int[]{cache.get(cur), i};
            cache.put(nums[i], i);
        }
        return new int[0];
    }
}