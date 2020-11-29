class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length())
            return ans;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            c1[s.charAt(i) - 'a']++;
            c2[p.charAt(i) - 'a']++;
        }
        if (valid(c1, c2))
            ans.add(0);
        int begin = 0, end = p.length() - 1;
        while (end < s.length() - 1) {
            c1[s.charAt(begin++) - 'a']--;
            c1[s.charAt(++end) - 'a']++;
            if (valid(c1, c2))
                ans.add(begin);
        }
        return ans;
    }
    private boolean valid(int[] c1, int[] c2) {
        for (int i = 0; i < 26; ++i) {
            if (c1[i] != c2[i])
                return false;
        }
        return true;
    }
}