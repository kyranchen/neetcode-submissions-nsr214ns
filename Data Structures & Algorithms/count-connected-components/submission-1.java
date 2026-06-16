class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        int res = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int rootX = find(edge[0], parent);
            int rootY = find(edge[1], parent);

            if (rootX != rootY) {
                if (rank[rootX] >= rank[rootY]) parent[rootY] = rootX;
                else parent[rootX] = rootY;
                if (rank[rootX] == rank[rootY]) rank[rootX]++;
                res--;
            }
        }

        return res;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) return find(parent[x], parent);

        return x;
    } 
}
