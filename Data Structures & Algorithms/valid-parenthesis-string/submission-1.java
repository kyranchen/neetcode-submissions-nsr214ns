class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin ++;
                leftMax ++;
            } else if (c == ')') {
                leftMin --;
                leftMax --;
            } else {
                leftMin --;
                leftMax ++;
            }

            if (leftMax < 0) return false;

            // reset leftMin to 0 since it could be negative by wildcard
            if (leftMin < 0) leftMin = 0;
        }

        return leftMin == 0;
    }
}
