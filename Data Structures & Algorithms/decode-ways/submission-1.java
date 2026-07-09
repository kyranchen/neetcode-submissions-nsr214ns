class Solution {
    public int numDecodings(String s) {
        // Use a dp array to keep track of the ways for each index
        // dp[i] = the max number of ways to decode from index 0 to i
        // edge case is 0 at the front of the two digit

        if (s.length() == 0) return 0;

        // edge case where the first character is 0
        if (s.charAt(0) == '0') return 0;

        if (s.length() == 1) return 1;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            // The single digit can be decoded
             if (curr != '0') {
                dp[i] += dp[i - 1];
            }

            // Two digit decode (only valid if in range 10-26)
            int twoDigit = (prev - '0') * 10 + (curr - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }

        }

        return dp[n];
    }
}
