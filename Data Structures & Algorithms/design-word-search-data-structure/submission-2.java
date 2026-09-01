class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode trav = root;
        for (char ch : word.toCharArray()) {
            if (trav.children[ch - 'a'] == null) {
                trav.children[ch - 'a'] = new TrieNode();
            }

            trav = trav.children[ch - 'a'];
        }

        trav.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (index >= word.length()) return node.isWord;

        char ch = word.charAt(index);

        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && dfs(word, index + 1, node.children[i])) return true;
            }

            return false;
        } else {
            if (node.children[ch - 'a'] == null) {
                return false;
            } else {
                return dfs(word, index + 1, node.children[ch - 'a']);
            }
        }
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
