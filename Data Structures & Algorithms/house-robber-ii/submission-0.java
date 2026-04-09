class Solution {
    public int rob(int[] nums) {
        // Three cases
        // 1. Rob first
        // 2. Rob last
        // 3. Rob neither
        int N = nums.length;
        if (N == 1) return nums[0];
        if (N == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        // Case 1
        int[] first = new int[N];
        first[0] = nums[0];
        first[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < N - 1; i++) {
            first[i] = Math.max(first[i - 2] + nums[i], first[i - 1]);
        }

        first[N - 1] = first[N - 2];

        // Case 2
        int[] last = new int[N];
        last[N - 1] = nums[N - 1];
        last[N - 2] = nums[N - 2] > nums[N - 1] ? nums[N - 2] : nums[N - 1];

        for (int i = N - 3; i >= 1; i--) {
            last[i] = Math.max(last[i + 2] + nums[i], last[i + 1]);
        }

        // Case 3
        int[] neither = new int[N];
        neither[1] = nums[1];

        for (int i = 2; i < N - 1; i++) {
            neither[i] = Math.max(neither[i - 2] + nums[i], neither[i - 1]);
        }


        return Math.max(Math.max(first[N - 1], last[1]), neither[N - 2]);
    }
}
