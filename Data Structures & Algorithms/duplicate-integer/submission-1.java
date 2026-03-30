class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Sol 1: Sort the array and loop thru to check adj element
        // Time: O(nlogn), Space: O(1)

        // Sol 2: Freq map
        // Time: O(n), Space: O(n)

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }

        return false;
    }
}