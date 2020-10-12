/**
 *
 *	使用HashMap统计每个数字出现的次数
 *  构建小顶堆 将数字加入堆，如果超出K则移除堆顶元素 最后剩余的数字即为高频元素
 *  
 *
 **/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> eleTimesMap = new HashMap<>();
        for(int num : nums){
            eleTimesMap.put(num, eleTimesMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        for(Map.Entry<Integer, Integer> eleTimesEntry : eleTimesMap.entrySet()){
            int ele = eleTimesEntry.getKey(), times = eleTimesEntry.getValue();
            if(pq.size() == k){
                if(pq.peek()[1] < times){
                    pq.poll();
                    pq.offer(new int[]{ele, times});
                }
            }else{
                pq.offer(new int[]{ele, times});
            }
        }

        int[] result = new int[k];
        for(int i = 0;i < k;i ++){
            result[i] = pq.poll()[0];
        }
        return result;
    }
}