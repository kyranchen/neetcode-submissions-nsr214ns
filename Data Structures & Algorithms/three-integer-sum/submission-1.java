class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int N = nums.length;

        // Sol 1: Brute force
        // Time: O(n^3)

        // Sol 2: Three pointer

        // [-1,0,1,2,-1,-4]
        // [-4, -1, -1, 0, 1, 2]

        for (int i = 0; i < N - 2; i++) {
            int target = -1 * nums[i];
            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                if (target == nums[left] + nums[right]) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left += 1;
                } else if (target < nums[left] + nums[right]) {
                    right --;
                } else {
                    left ++;
                }
            }
        }

        return res;
    }
}
