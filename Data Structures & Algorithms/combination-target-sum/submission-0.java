class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        helper(0, nums, new ArrayList<>(), 0, target, res);

        return res;
    }

    private void helper(int index, int[] nums, List<Integer> curr, int total, int target, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (total + nums[i] > target) return;

            curr.add(nums[i]);
            helper(i, nums, curr, total + nums[i], target, res);
            curr.remove(curr.size() - 1);
        }
    }
}
