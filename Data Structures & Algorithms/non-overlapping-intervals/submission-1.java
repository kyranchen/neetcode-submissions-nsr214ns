class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        if (n <= 1) return 0;

        // Sort by starting values
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return n - dfs(intervals, dp, 0);
    }

    private int dfs(int[][] intervals, int[] dp, int i) {
        if (i >= intervals.length) return 0;

        if (dp[i] != -1) return dp[i];

        int res = 1;
        for (int j = i + 1; j < intervals.length; j++) {
            if (intervals[i][1] <= intervals[j][0]) {
                res = Math.max(res, 1 + dfs(intervals, dp, j));
            }
        }

        dp[i] = res;

        return res;
    }
}
