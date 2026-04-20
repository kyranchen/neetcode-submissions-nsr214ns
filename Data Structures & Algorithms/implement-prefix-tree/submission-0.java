class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode trav = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (trav.children[index] == null) trav.children[index] = new TrieNode();
            trav = trav.children[index];
        }

        trav.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode trav = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (trav.children[index] == null) return false;
            trav = trav.children[index];
        }

        return trav.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode trav = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (trav.children[index] == null) return false;
            trav = trav.children[index];
        }

        return true;
    }
}
