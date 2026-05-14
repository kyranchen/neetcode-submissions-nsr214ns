class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (!visited.contains(n)) {
            visited.add(n);
            int res = helper(n);
            if (res == 1) return true;
            System.out.println(res);
            n = res;
        }

        return false;
    }

    private int helper(int num) {
        // Calculates the sum of the squares of its digits
        int res = 0;
        while (num > 0) {
            int digit = num % 10;
            res += digit * digit;
            num = num / 10;
        }

        return res;
    }
}
