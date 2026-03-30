class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Add indexes to stack until a larger value has been seen

        Stack<Integer> stack = new Stack<>();
        int N = temperatures.length;

        if (N == 1) return new int[]{0};

        int[] res = new int[N];
        int index = 1;
        stack.push(0);

        while (index < N) {
            int top = stack.peek();
            while (!stack.isEmpty() && temperatures[top] < temperatures[index]) {
                res[top] = index - top;
                stack.pop();
                top = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(index);
            index ++;
        }

        return res;
    }
}
