class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) != '0')
                dp[i + 1] = dp[i];
            int num = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');
            if (num >= 10 && num <= 26)
                dp[i + 1] += dp[i - 1];
        }
        return dp[n];
    }
}