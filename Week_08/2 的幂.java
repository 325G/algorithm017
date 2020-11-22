/**
 * 一个数如果是2的n次方 则二进制位中有且仅有一个1
 *
 **/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }
}