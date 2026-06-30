class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        res = new ArrayList<>();

        backtrack(new ArrayList<>(), candidates, 0, 0, target);

        return res;
    }

    private void backtrack(List<Integer> curr, int[] candidates, int sum, int index, int target) {
        if (sum >= target) {
            if (sum == target) res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            curr.add(candidates[i]);
            backtrack(curr, candidates, sum + candidates[i], i + 1, target);
            curr.removeLast();
        }

        return;
    }
}
