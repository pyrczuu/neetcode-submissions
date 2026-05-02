class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean end;

    public TrieNode() {
        this.children = new HashMap<>();
        this.end = false;
    }
}


class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        return dfs(word, curr);
    }

    private boolean dfs(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (char child : node.children.keySet()) {
                    if (dfs(word.substring(i+1, word.length()), node.children.get(child))) return true;
                }
                return false;
            } else {
                if (!node.children.containsKey(c)) return false;
                node = node.children.get(c);
            }
        }
        return node.end;
    }
}
