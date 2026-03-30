class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int max = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(i, j, grid));
            }
        }

        return max;
    }

    private int dfs(int row, int col, int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        if (row >= M || row < 0 || col >= N || col < 0 || grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = -1;

        return 1 + dfs(row + 1, col, grid) + 
            dfs(row - 1, col, grid) + 
            dfs(row, col + 1, grid) + 
            dfs(row, col - 1, grid);
    }
}
