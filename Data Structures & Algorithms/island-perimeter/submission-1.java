class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return dfs(i, j, visited, grid);
            }
        }

        return 0;
    }

    private int dfs(int row, int col, boolean[][] visited, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (row >= m || row < 0 || col >= n || col < 0 || grid[row][col] == 0) return 1;

        if (visited[row][col]) return 0;

        visited[row][col] = true;

        return dfs(row + 1, col, visited, grid) + dfs(row - 1, col, visited, grid) + 
                dfs(row, col + 1, visited, grid) + dfs(row, col - 1, visited, grid);
    }
}