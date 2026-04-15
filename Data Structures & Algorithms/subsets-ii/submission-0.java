class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>());

        return res;
    }

    private void helper(int index, int[] nums, List<Integer> curr) {
        res.add(new ArrayList<>(curr));
        
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);
            helper(i + 1, nums, curr);
            curr.remove(curr.size() - 1);
        }

    }
}
