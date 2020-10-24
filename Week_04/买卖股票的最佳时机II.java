/*
 * 贪心算法
 * 比较当天与前一天的价格如果有收益就出售，累积计算总利润
 *
 **/
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, i = 0;
        for (int j = 1; j < prices.length; ++j) {
            if (prices[j] > prices[i])
                ans += prices[j] - prices[i];
            ++i;
        }
        return ans;
    }
}