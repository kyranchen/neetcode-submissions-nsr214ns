class Solution {
    Set<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        // Use a trie to insert the words into the data structure
        // Use a visited 2D list to mark the cells
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode trav = root;

            for (char ch : word.toCharArray()) {
                if (trav.children[ch - 'a'] == null) trav.children[ch - 'a'] = new TrieNode();
                trav = trav.children[ch - 'a'];
            }
            trav.isWord = true;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        res = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false) {
                    backtrack(i, j, board, visited, root, "");
                }
            }
        }

        return new ArrayList<>(res);
    }

    private void backtrack(int row, int col, char[][] board, boolean[][] visited, TrieNode node, String word) {
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) return;

        char ch = board[row][col];
        if (node.children[ch - 'a'] == null) return;

        visited[row][col] = true;
        node = node.children[ch - 'a'];
        word += ch;
        if (node.isWord) res.add(word);

        backtrack(row + 1, col, board, visited, node, word);
        backtrack(row - 1, col, board, visited, node, word);
        backtrack(row, col + 1, board, visited, node, word);
        backtrack(row, col - 1, board, visited, node, word);

        visited[row][col] = false;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}
