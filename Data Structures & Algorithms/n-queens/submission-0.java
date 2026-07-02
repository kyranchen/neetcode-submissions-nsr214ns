class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        backtrack(grid, 0, res);

        return res;
    }

    private void backtrack(char[][] grid, int row, List<List<String>> res) {
        if (row >= grid.length) {
            List<String> curr = new ArrayList<>();
            for (char[] data : grid) {
                curr.add(new String(data));
            }
            res.add(curr);
            return;
        }

        for (int j = 0; j < grid.length; j++) {
            if (isValid(grid, row, j)) {
                grid[row][j] = 'Q';
                backtrack(grid, row + 1, res);
                grid[row][j] = '.';
            } 
        }
    }

    private boolean isValid(char[][] grid, int row, int col) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            if (grid[i][col] == 'Q' || grid[row][i] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (grid[i][j] == 'Q') return false;
        }

        return true;
    }
}
