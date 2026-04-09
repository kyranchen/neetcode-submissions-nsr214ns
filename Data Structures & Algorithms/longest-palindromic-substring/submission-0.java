class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();

        int res = Integer.MIN_VALUE;
        int[] resIndex = new int[]{0, 0};
        // Odd center
        for (int i = 0; i < N; i++) {
            int[] currIndex = checkPalindrome(i, i, s);
            int curr = currIndex[1] - currIndex[0] + 1;
            if (curr > res) {
                res = curr;
                resIndex = currIndex;
            }
        }

        // Even center
        for (int i = 0; i < N - 1; i++) {
            int[] currIndex = checkPalindrome(i, i + 1, s);
            int curr = currIndex[1] - currIndex[0] + 1;
            if (curr > res) {
                res = curr;
                resIndex = currIndex;
            }
        }

        return s.substring(resIndex[0], resIndex[1] + 1);
    }

    private int[] checkPalindrome(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }

        return new int[]{left + 1, right - 1};
    }
}
