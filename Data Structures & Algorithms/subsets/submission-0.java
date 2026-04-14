class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        helper(0, nums, new ArrayList<>(), res);

        return res;
    }

    private void helper(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (index > nums.length) return;

        res.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(i + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
