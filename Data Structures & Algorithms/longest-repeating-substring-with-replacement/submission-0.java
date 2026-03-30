class Solution {
    public int characterReplacement(String s, int k) {

        int max = 0;
        int N = s.length();
        int[] freq = new int[256];
        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < N; right++) {
            freq[s.charAt(right)] += 1;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right)]);

            // Window size condition check
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left)] -= 1;
                left += 1;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
