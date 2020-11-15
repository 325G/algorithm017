class Trie {
    boolean end;
    Trie[] next = new Trie[26];
    /** Initialize your data structure here. */
    public Trie() {

    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        Trie trie = this;
        for (char c : word.toCharArray()) {
            if (trie.next[c - 'a'] == null)
                trie.next[c - 'a'] = new Trie();
            trie = trie.next[c - 'a'];
        }
        trie.end = true;
        
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = findPrefix(word);
        return node != null && node.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return findPrefix(prefix) != null;
    }
    private Trie findPrefix(String word) {
        if (word == null || word.length() == 0)
            return null;
        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null)
                return null;
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */