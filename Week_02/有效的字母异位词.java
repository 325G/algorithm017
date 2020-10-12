/**
 *
 *	采用计数规则 s字符串出现的字母+1在t字符串出现的同样字母-1
 *  使用长度26的字符类型数组记录字母出现的情况
 *
 **/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] cache = new char[26];
        for (int i = 0; i < s.length(); ++i) {
            cache[s.charAt(i) - 'a']++;
            cache[t.charAt(i) - 'a']--;
        }
        return String.valueOf(cache).trim().isBlank();
    }
}