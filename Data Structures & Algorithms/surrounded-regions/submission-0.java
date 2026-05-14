class Solution {
    public void solve(char[][] board) {
        // Traverse through the graph and if O cannot reach the border change them

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (!dfs(i, j, board, new HashSet<>())) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private boolean dfs(int row, int col, char[][] board, HashSet<String> visited) {
        int m = board.length;
        int n = board[0].length;

        if (board[row][col] == 'O' && (row <= 0 || row >= m - 1 || 
        col <= 0 || col >= n - 1)) {
            return true;
        }

        if (visited.contains(row + "->" + col) || board[row][col] == 'X') return false;

        visited.add(row + "->" + col);
        
        return dfs(row + 1, col, board, visited) ||
                dfs(row - 1, col, board, visited) ||
                dfs(row, col + 1, board, visited) ||
                dfs(row, col - 1, board, visited);
    }
}
