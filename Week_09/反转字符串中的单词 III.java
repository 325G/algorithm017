class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" +");
        for (int i = 0; i < arr.length; ++i) {
            char[] crr = arr[i].toCharArray();
            int begin = 0, end = crr.length - 1;
            while (begin < end) {
                char c = crr[begin];
                crr[begin++] = crr[end];
                crr[end--] = c;
            }
            arr[i] = String.valueOf(crr);
        }
        return String.join(" ", arr);
    }
}