/**
 *
 *	丑数 * 丑数 依然是一个丑数
 *  使用数组存储因子数，构建小顶堆存储丑数 将堆顶元素依次与因子数相乘后再加入堆直到找到第N个数
 *  
 *
 **/
class Solution {
    int[] uglyNumbers = {2,3,5};
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        int count = 0;
        while (true) {
            long num = heap.poll();
            if (++count == n) return (int) num;
            for (int uglyNumber : uglyNumbers) {
                if (!heap.contains(uglyNumber * num)) heap.offer(uglyNumber * num);
            }
         }
    }
}