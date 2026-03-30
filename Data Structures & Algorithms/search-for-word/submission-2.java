class Solution {
    public boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (dfs(i, j, board, word, 0, new boolean[M][N]) == true) return true;
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, char[][] board, String word, 
        int index, boolean[][] visited) {

        int M = board.length;
        int N = board[0].length;


        if (row >= M || row < 0 || col >= N || col < 0 ||
            word.charAt(index) != board[row][col] || 
            visited[row][col] == true) {
                return false;
        }

        visited[row][col] = true;

        if (word.length() == index + 1) return true;

        boolean res = dfs(row + 1, col, board, word, index + 1, visited)||
                dfs(row - 1, col, board, word, index + 1, visited) ||
                dfs(row, col + 1, board, word, index + 1, visited)||
                dfs(row, col - 1, board, word, index + 1, visited);

        visited[row][col] = false;

        return res;
    }
}
