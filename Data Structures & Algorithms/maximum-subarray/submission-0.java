class Solution {
    public int maxSubArray(int[] nums) {
        // As we traverse thru the array
        // When we encounter a number larger than the current sum
        // If the curr sum is negative, replace the sum

        int n = nums.length;
        int max = nums[0];
        int curr = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > curr) {
                if (curr < 0) {
                    curr = nums[i];
                } else {
                    curr += nums[i];
                }
            } else {
                curr += nums[i];
            }

            System.out.println(curr);
            max = Math.max(max, curr);
        }

        return max;
    }
}
