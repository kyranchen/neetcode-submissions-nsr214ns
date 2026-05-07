class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs(res, new StringBuilder(), 0, 0, n);

        return res;
    }
    
    private void dfs(List<String> res, StringBuilder curr, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(curr.toString());
            return;
        }

        if (left < n) {
            curr.append('(');
            dfs(res, curr, left + 1, right, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (right < left) {
            curr.append(')');
            dfs(res, curr, left, right + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
