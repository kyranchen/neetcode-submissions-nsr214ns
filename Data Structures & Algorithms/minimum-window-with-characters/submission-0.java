class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int N = s.length();
        int M = t.length();
        
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for (int i = 0; i < M; i++) {
            freq2.put(t.charAt(i), freq2.getOrDefault(t.charAt(i), 0) + 1);
        }

        int curr = 0;
        int need = t.length();
        int minLen = Integer.MAX_VALUE;
        int[] minIndex = {-1, -1};

        int left = 0;
        int right = 0;

        while (right < N) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            int freq = freq2.getOrDefault(ch, 0);

            if (window.get(ch) <= freq) {
                curr += 1;
            }

            while (curr == need) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minIndex = new int[]{left, right};
                }
                
                char leftChar = s.charAt(left);
                if (freq2.getOrDefault(leftChar, 0) > 0 && 
                    freq2.get(leftChar) >= window.get(leftChar)) {
                    curr -= 1;
                }
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }

            right += 1;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minIndex[0], minIndex[1] + 1);
    }
}
