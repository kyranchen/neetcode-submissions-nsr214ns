class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        int ord = (int)'a';

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            int index = (int)s.charAt(i);
            int index2 = (int)t.charAt(i);

            freqS[index - ord] += 1;
            freqT[index2 - ord] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (freqS[i] != freqT[i]) return false;
        }

        return true;
    }
}
