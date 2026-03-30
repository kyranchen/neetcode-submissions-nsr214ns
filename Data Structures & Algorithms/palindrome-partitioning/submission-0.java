class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        
        backtrack(0, s, new ArrayList<>());

        return res;
    }

    private void backtrack(int index, String s, List<String> curr) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s.substring(index, i + 1))) {
                curr.add(s.substring(index, i + 1));
                backtrack(i + 1, s, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }


    private boolean isPalindrome(String s) {
        int N = s.length();

        if (N <= 1) return true;

        int left = 0;
        int right = N - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;

            left += 1;
            right -= 1;
        }

        return true;
    }
}
