public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curt = root;
        for (char c: word.toCharArray()) {
            if (curt.children[c - 'a'] == null) curt.children[c - 'a'] = new TrieNode();
            curt = curt.children[c - 'a'];
        }
        curt.val = word;
    }
}
