/**
 *
 *	每个异位词处理方式同题目有效字母异位词
 *  将每个异位词根据出现字母次数构建Key
 *  使用HashMap存储相同key的异位词
 *  
 *
 **/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap<>();
        char[] cache = new char[26];
        for (String str : strs) {
            Arrays.fill(cache, 'a');
            for (char c : str.toCharArray()) cache[c - 'a']++;
            String key = String.valueOf(cache);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}