class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int match = 0;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == freq2[i]) match++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (match == 26) return true;

            int left = s2.charAt(i - s1.length()) - 'a';
            if (freq1[left] == freq2[left]) match--;
            freq2[left]--;
            if (freq1[left] == freq2[left]) match++;

            int right = s2.charAt(i) - 'a';
            if (freq1[right] == freq2[right]) match--;
            freq2[right]++;
            if (freq1[right] == freq2[right]) match++;
        }

        return match == 26;
    }
}
