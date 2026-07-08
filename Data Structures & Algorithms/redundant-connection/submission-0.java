class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // Do a cycle detection with Kahn's Algo
        // Then iterate through edges from the back
        // If both nodes are not in the visited array
        // We know that they are part of the cycle
        int n = edges.length + 1;
        boolean[] visited = new boolean[n + 1];

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            indegree[e[0]] += 1;
            indegree[e[1]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] <= 1) queue.offer(i); 
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for (int neighbor : adj.get(node)) {
                indegree[neighbor] -= 1;
                if (indegree[neighbor] == 1) {
                    queue.offer(neighbor);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] e = edges[i];
            if (!visited[e[0]] && !visited[e[1]]) return e;
        }

        return edges[0];
    }
}
