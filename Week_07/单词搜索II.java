class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, i, j, trie.root , ans);
                            }
        }
        return ans;
    }
    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> ans) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null)
            return;
        node = node.next[c - 'a'];
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
            return;
        }
        board[i][j] = '#';
        for (int k = 0; k < 4; ++k) {
            dfs(board, dx[k] + i, dy[k] + j, node, ans);
        }
        board[i][j] = c;
    }
    class Trie {
        TrieNode root = new TrieNode();
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null)
                    node.next[c - 'a'] = new TrieNode();
                node = node.next[c - 'a'];
            }
            node.word = word;
        }
    }
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null;
    }
}