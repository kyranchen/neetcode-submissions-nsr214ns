class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> arr = new ArrayList<>();

        int n = digits.length;
        int sub = 0;
        digits[n - 1] += 1;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] + sub >= 10) {
                sub = 1;
                arr.add(0);
            } else {
                arr.add(digits[i] + sub);
                sub = 0;
            }
        }

        if (sub == 1) arr.add(1);

        int[] res = new int[arr.size()];
        int index = 0;

        for (int i = arr.size() - 1; i >= 0; i--) {
            res[index] = arr.get(i);
            index += 1;
        }

        return res;
    }
}
