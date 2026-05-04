class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie prefixTree = buildTree(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, prefixTree, i, j, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, Trie node, int i, int j, List<String> res) {
        char c = board[i][j];

        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, node, i - 1, j, res);
        if (j > 0) dfs(board, node, i , j-1, res);
        if (i < board.length-1) dfs(board, node, i+1, j, res);
        if (j < board[0].length-1) dfs(board, node, i, j+1, res);
        board[i][j] = c;
    }

    class Trie {
        Trie[] children = new Trie[26];
        String word;
    }

    public Trie buildTree(String[] words) {
        Trie root = new Trie();

        for (String word : words) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) node.children[idx] = new Trie();
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
}

}
