class Solution {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        // Key: value, Value: index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < N; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }

        return nums;
    }
}
