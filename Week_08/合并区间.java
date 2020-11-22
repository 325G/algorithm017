/**
 * 以左区间为主进行排序，然后依次检查后序区间的右区间与最后一个检查过的的左区间比较，如果超过最后一个检查的区间的左区间 作为新区间，否则合并
 *
 **/
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][2];
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> ans = new ArrayList<>();
        for (int i = 0;i < intervals.length; ++i) {
            int left = intervals[i][0], right = intervals[i][1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < left) {
                ans.add(new int[]{left, right});
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(right, ans.get(ans.size() - 1)[1]);
            }
        }   
        return ans.toArray(new int[ans.size()][]);
    }
}