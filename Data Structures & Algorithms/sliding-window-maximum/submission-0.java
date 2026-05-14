class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int[] res = new int[n - k + 1];

        res[0] = pq.peek()[0];
        int index = 1;

        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (!pq.isEmpty() && pq.peek()[1] < i - k + 1) {
                pq.poll();
            }

            res[index++] = pq.peek()[0];
        }

        return res;
    }
}
