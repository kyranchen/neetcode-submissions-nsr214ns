class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;

        boolean isNegative = n < 0;
        int normalized = n > 0 ? n : -1 * n;

        double[] dp = new double[normalized + 1];

        dp[0] = 1;
        dp[1] = x;

        return isNegative ? 1/backtrack(dp, x, normalized) : backtrack(dp, x, normalized);
    }

    private double backtrack(double[] dp, double x, int n) {
        if (n <= 1) {
            return dp[n];
        }

        double res = n % 2 == 0 ? backtrack(dp, x, n / 2) * backtrack(dp, x, n / 2)
                : backtrack(dp, x, n / 2) * backtrack(dp, x, n / 2 + 1);

        dp[n] = res;
        return res;
    }
}
