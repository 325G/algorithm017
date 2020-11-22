/**
 *
 * 答案数字初始化为0每次左移一位 然后加上原数最后一位 通过n & 1得到最后一位二进制位
 * 原数每次右移一位 即每次去掉最低位
 *
 **/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans;
    }
}