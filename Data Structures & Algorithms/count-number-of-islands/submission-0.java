class Solution {
    final int[] DIRS = {1, 0, -1, 0, 1};
    public int numIslands(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int res = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    dfs(i, j, grid);
                }
            }
        }

        return res;
    }

    private void dfs(int row, int col, char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        if (row >= M || row < 0 || col >= N || col < 0 || grid[row][col] != '1') return;

        grid[row][col] = '0';

        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);

        return;
    }

}
