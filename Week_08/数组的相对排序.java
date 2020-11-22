/**
 *
 * 计数排序 因为数字不超过1000因此不会有较多内存消耗
 * 临时数组记录arr1中每个数字出现的次数，遍历arr2 将数字从临时数组中取出，已取出数字位个数标记为0
 * 将剩余数字从临时数组中取出
 *
 **/
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;
        for (int num1 : arr1) {
            max = Math.max(max, num1);
        }
        int[] temp = new int[max + 1];
        for (int num1 : arr1) {
            temp[num1]++;
        }
        int[] ans = new int[arr1.length];
        int idx = 0;
        for (int num2 : arr2) {
            for (int i = 0; i < temp[num2]; ++i) {
                ans[idx++] = num2;
            }
            temp[num2] = 0;
        }
        for (int i = 0; i < temp.length; ++i) {
            for (int j = 0; j < temp[i]; ++j) {
                ans[idx++] = i;
            }
        }
        return ans;
    }
}