class Solution {
    public boolean canJump(int[] nums) {
        // Brute force => exponential time
        // Bottom up
        int N = nums.length;

        boolean[] dp = new boolean[N];

        dp[0] = true;

        for (int i = 0; i < N; i++) {
            if (nums[i] > 0 && dp[i]) {
                if (nums[i] + i >= N) return true;
                for (int j = 1; j <= nums[i]; j++) {
                    dp[i + j] = true;
                }
            }
        }

        return dp[N - 1];
    }
}
