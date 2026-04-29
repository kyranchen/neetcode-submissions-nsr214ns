class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        dfs(nums, new ArrayList<>(), new boolean[nums.length]);

        return res;
    }

    private void dfs(int[] nums, List<Integer> curr, boolean[] used) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                curr.add(nums[i]);
                dfs(nums, curr, used);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
}
