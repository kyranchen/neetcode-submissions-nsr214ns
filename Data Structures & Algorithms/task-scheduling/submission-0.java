class Solution {
    public int leastInterval(char[] tasks, int n) {
        // A pq to store the frequency and the characters(tasks)
        // A queue to make sure idle time is given
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A'] ++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();

        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        int time = 0;

        while (!pq.isEmpty() || !queue.isEmpty()) {
            time ++;

            if (!pq.isEmpty()) {
                int taskCount = pq.poll() - 1;
                if (taskCount > 0) {
                    queue.add(new int[]{taskCount, time + n});
                }
            } else {
                time = queue.peek()[1];
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                pq.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
