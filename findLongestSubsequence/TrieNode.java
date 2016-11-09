public class TrieNode {
    TrieNode[] children;
    String val;

    public TrieNode() {
        children = new TrieNode[26];
        val = "";
    }
}
