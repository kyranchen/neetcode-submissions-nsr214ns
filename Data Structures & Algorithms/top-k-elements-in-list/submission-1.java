class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            freq.putIfAbsent(nums[i], 0);
            freq.put(nums[i], freq.get(nums[i]) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});

            if (queue.size() > k) queue.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        
        return res;
    }
}
