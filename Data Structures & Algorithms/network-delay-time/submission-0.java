class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Use BFS(Dijkstra's) to find the shortest path to all nodes

        HashMap<Integer, List<int[]>> map = new HashMap<>();
        // int[i, j] => i = node, j = current distance
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        HashMap<Integer, Integer> dist = new HashMap<>();

        for (int[] time : times) {
            int source = time[0];

            map.putIfAbsent(source, new ArrayList<>());
            map.get(source).add(new int[]{time[1], time[2]});
        }

        queue.offer(new int[]{k, 0});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int node = cell[0];
            int distance = cell[1];

            if (dist.containsKey(node)) continue;

            dist.put(node, distance);

            List<int[]> neighbors = map.getOrDefault(node, new ArrayList<>());
            for (int[] neighbor: neighbors) {
                int neighborNode = neighbor[0];
                if (!dist.containsKey(neighborNode)) {
                    queue.offer(new int[]{neighborNode, distance + neighbor[1]});
                }
            }
        }

        return dist.size() == n ? Collections.max(dist.values()) : -1;
    }
}
