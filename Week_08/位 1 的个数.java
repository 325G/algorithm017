/**
 * n & (n - 1) 去掉二进制最低位1 统计去掉的个数
 *
 **/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n &= n - 1;
        }
        return ans;
    }
}