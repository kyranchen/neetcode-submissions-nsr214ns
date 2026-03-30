class Solution {
    public int longestConsecutive(int[] nums) {
        int N = nums.length;

        // Sol 1 Sorting
        // Time: O(nlogn)

        // Sol 2 HashMap

        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num: nums) set.add(num);

        for (int i = 0; i < N; i++) {
            int start = nums[i];
            int curr = 1;

            while (set.contains(start + 1)) {
                curr ++;
                start++;
            }

            max = Math.max(curr, max);

        }

        return max;
    }
}
