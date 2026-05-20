class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        boolean[][] visited1 = new boolean[m][n];
        boolean[][] visited2 = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, visited1, pacific, heights, -1);
            dfs(i, n - 1, visited2, atlantic, heights, -1);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, visited1, pacific, heights, -1);
            dfs(m - 1, j, visited2, atlantic, heights, -1);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    res.add(new ArrayList<>(curr));
                }
            }
        }

        return res;
    }

    private void dfs(int row, int col, boolean[][] visited, boolean[][] reachable, int[][] heights, int prev) {
        int m = heights.length;
        int n = heights[0].length;

        if (row >= m || row < 0 || col >= n || col < 0 || visited[row][col] || heights[row][col] < prev) {
            return;
        }

        visited[row][col] = true;
        reachable[row][col] = true;

        dfs(row + 1, col, visited, reachable, heights, heights[row][col]);
        dfs(row - 1, col, visited, reachable, heights, heights[row][col]);
        dfs(row, col + 1, visited, reachable, heights, heights[row][col]);
        dfs(row, col - 1, visited, reachable, heights, heights[row][col]);

        return;
    }
}
