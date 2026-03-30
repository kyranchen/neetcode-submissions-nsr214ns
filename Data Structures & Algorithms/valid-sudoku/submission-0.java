class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = board[i][j];
                if (board[i][j] == '.') continue;
                if (!(checkCol(value, i, j, board) && 
                checkRow(value, i, j, board) && 
                checkGrid(value, i, j, board))) return false;
            }
        }

        return true;
    }

    private boolean checkCol(int value, int row, int col, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (row != i && board[i][col] == value) return false;
        }

        return true;
    }

    private boolean checkRow(int value, int row, int col, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (col != i && board[row][i] == value) return false;
        }

        return true;
    }

    private boolean checkGrid(int value, int row, int col, char[][] board) {
        int gridRow = row / 3;
        int gridCol = col / 3;

        for (int i = gridRow * 3; i < gridRow * 3 + 3; i++) {
            for (int j = gridCol * 3; j < gridCol * 3 + 3; j++) {
                if (!(i == row && j == col) && board[i][j] == value) return false;
            }
        }

        return true;
    }
}
