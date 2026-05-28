class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;

        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder curr) {
        if (index == digits.length()) {
            res.add(curr.toString());
            return;
        }

        char digit = digits.charAt(index);
        String target = digitToChar[digit - '0'];
        for (char ch : target.toCharArray()) {
            curr.append(ch + "");
            backtrack(digits, index + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        
        return;
    }
}
