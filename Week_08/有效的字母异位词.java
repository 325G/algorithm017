/**
 * 计数方式统计两个字符串的字符出现次数 s出现一次加1 t出现一次减1 26个字母数量为0则为异位词
 *
 **/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] cache = new char[26];
        for (int i = 0; i < s.length(); ++i) {
            cache[s.charAt(i) - 'a']++;
            cache[t.charAt(i) - 'a']--;
        }
        return String.valueOf(cache).trim().isBlank();
    }
}