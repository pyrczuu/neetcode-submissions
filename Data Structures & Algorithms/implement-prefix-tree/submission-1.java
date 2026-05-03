class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean end;

    public TrieNode() {
        this.children = new HashMap<>();
        this.end = false;
    }
}


class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children.getOrDefault(c, null) == null) curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()) {
            if (curr.children.getOrDefault(c, null) == null) return false;
            curr = curr.children.get(c);
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for (char c : prefix.toCharArray()) {
            if (curr.children.getOrDefault(c, null) == null) return false;
            curr = curr.children.get(c);
        }
        return true;
    }
}
