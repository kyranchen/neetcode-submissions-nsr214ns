class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] prefixSum = new int[N];
        int[] postfixSum = new int[N];
        int[] res = new int[N];

        prefixSum[0] = 1;
        postfixSum[N - 1] = 1;

        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] * nums[i - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            postfixSum[i] = postfixSum[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < N; i++) {
            res[i] = prefixSum[i] * postfixSum[i];
        }

        return res;
    }
}  
