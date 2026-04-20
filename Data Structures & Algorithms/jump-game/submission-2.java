class Solution {
    public boolean canJump(int[] nums) {
        // Brute force => exponential time
        // Bottom up
        int N = nums.length;

        boolean[] dp = new boolean[N];

        dp[N - 1] = true;

        for (int i = N - 2; i >=0; i--) {
            int end = Math.min(N, i + nums[i] + 1);
            for (int j = i + 1; j < end; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
