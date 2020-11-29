class Solution {
    public String reverseWords(String s) {
        String[] c = s.trim().split(" +");
        Collections.reverse(Arrays.asList(c));
        return String.join(" ", c);
    }
}