class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int[] freq = new int[256];
        int N = s.length();
        int left = 0;
        int right = 1;
        int res = 0;

        freq[(int)s.charAt(left)] += 1;

        while (right < s.length()) {
            int index = (int)s.charAt(right);
            if (freq[index] >= 1) {
                res = Math.max(right - left, res);
                while (freq[index] >= 1) {
                    int leftIndex = (int)s.charAt(left);
                    freq[leftIndex] -= 1;
                    left += 1;
                }
            } else {
                freq[index] += 1;
                right += 1;
            }
        }

        res = Math.max(right - left, res);
        return res;
    }
}
