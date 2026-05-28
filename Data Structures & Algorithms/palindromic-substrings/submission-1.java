class Solution {
    private int res = 0;
    public int countSubstrings(String s) {
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            check(s, i, i);
            check(s, i, i + 1);
        }

        return res + 1;
    }

    private void check(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res += 1;
            left -= 1;
            right += 1;
        }

        return;
    }
}
