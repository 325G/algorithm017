/**
 * 贪心算法
 * 升序排序小孩与饼干 优先将小饼干送给胃口小的小朋友
 * 遍历一次饼干即可知道能送出几块
 **/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < s.length; ++i) {
            if (j == g.length)
                return g.length;
            if (s[i] >= g[j]){
                ans++;
                j++;
            }
                
        }
        return ans;
    }
}