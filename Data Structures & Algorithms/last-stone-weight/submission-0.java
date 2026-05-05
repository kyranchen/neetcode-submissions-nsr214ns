class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : stones) {
            pq.offer(num);
        }

        while (pq.size() > 1) {
            int rock1 = pq.poll();
            int rock2 = pq.poll();

            if (rock1 > rock2) pq.offer(rock1 - rock2);
        }

        return pq.size() == 0 ? 0 : pq.peek();
    }
}
