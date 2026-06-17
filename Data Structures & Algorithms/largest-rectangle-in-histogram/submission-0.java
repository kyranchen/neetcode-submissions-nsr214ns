class Solution {
    public int largestRectangleArea(int[] heights) {
        // brute force => O(n * n)
        // stack to keep track of indices

        int max = 0;
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] cell = stack.pop();
                int index = cell[0];
                int h = cell[1];
                max = Math.max(max, h * (i - index));
                start = index;
            }

            stack.push(new int[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {
            max = Math.max(max, stack.peek()[1] * (n - stack.pop()[0]));
        }

        return max;
    }
}
