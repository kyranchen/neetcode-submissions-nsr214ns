class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Use DFS to detect if there is a cycle in the graph

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if (dfs(adj, visited, 0, -1) == true) return false;

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) return false;
        }

        return true;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> adj, boolean[] visited, int n
            , int parent) {
        if (visited[n] == true) {
            return true;
        }

        visited[n] = true;

        List<Integer> neighbors = adj.getOrDefault(n, new ArrayList<>());
        for (int neigh: neighbors) {
            if (neigh == parent) continue;
            if (visited[neigh]) return true;
            if (dfs(adj, visited, neigh, n) == true) return true;
        }

        return false;
    }
}
