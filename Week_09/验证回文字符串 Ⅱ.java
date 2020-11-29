class Solution {
    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            if (c[i] != c[j]) {
                return valid(Arrays.copyOfRange(c, i + 1, j + 1)) || valid(Arrays.copyOfRange(c, i, j));
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean valid(char[] c) {
        int i = 0, j = c.length - 1;
        while (i < j) {
            if (c[i++] != c[j--])
                return false;
        }
        return true;
    }
}