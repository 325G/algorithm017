/**
 * 先统计每个字母出现次数 然后在一次遍历找到第一个出现次数为1的字符
 *
 **/
class Solution {
    public int firstUniqChar(String s) {
        int[] cache = new int[26];
        for (char c : s.toCharArray()) {
            cache[c - 'a']++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (cache[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}