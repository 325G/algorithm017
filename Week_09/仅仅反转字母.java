class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        char[] ans = new char[arr.length];
        int idx = 0;
        for (int i = arr.length - 1; i >= 0; --i) {
            while (idx < arr.length && !Character.isLetter(arr[idx])) {
                ans[idx] = arr[idx];
                idx++;

            }
            if(Character.isLetter(arr[i])) {
                ans[idx++] = arr[i];
            }
        }
        while (idx < arr.length) {
            ans[idx] = arr[idx];
            idx++;
        }
        return String.valueOf(ans);
    }
}