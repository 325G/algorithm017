/**
 *
 * 贪心算法 
 * 优先使用大额的币种 每次找零如果硬币数量小于0 则说明无法找零
 *
 **/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten = 0, five = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                five--;
                ten--;
            } else {
                five -= 3;
            }
            if (ten < 0 || five < 0)
                return false;
        }
        return true;
    }
}