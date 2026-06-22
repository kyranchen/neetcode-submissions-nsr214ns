class Solution {
    private int res;
    public int findTargetSumWays(int[] nums, int target) {
        // brute force => 2 ** n
        res = 0;

        backtrack(0, nums, 0, target);

        return res;
    }

    private void backtrack(int index, int[] nums, int curr, int target) {
        if (index >= nums.length) {
            if (curr == target) res += 1;
            return;
        }

        backtrack(index + 1, nums, curr + nums[index], target);
        backtrack(index + 1, nums, curr - nums[index], target);

        return;
    }
}
