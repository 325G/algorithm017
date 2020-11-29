class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i += 2 * k) {
            int begin = i, end = Math.min(c.length - 1, i + k - 1);
            while (begin < end) {
                char temp = c[begin];
                c[begin++] = c[end];
                c[end--] = temp;
            }
        }
        return String.valueOf(c);
    }
}