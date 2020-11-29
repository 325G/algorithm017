class Solution {
    public int myAtoi(String s) {
        int ans = 0, begin = 0, symbol = 0;
        while (begin < s.length() && s.charAt(begin) == ' ')
            begin++;
        for (int i = begin; i < s.length(); ++i) {
            char c = s.charAt(i);
            if ((c == '+' || c == '-') && symbol == 0) {
                symbol = (c == '+' ? 1 : -1);
            } else if (Character.isDigit(c)) {
                if (symbol == 0)
                    symbol = 1;
                if (ans > (Integer.MAX_VALUE - (c - '0')) / 10)
                    return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                ans = ans * 10 + (c - '0');
            } else if (ans == 0) {
                return 0;
            } else {
                break;
            }
        }
        return ans * symbol;
    }
}