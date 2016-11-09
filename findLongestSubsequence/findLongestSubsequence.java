import java.util.*;

public class findLongestSubsequence {

    public static void main(String[] args) {
        String[] words = {"ale", "apple", "monkey", "plea"};
        Trie trie = new Trie();

        for (String word: words) {
            trie.insert(word);
        }

        String s = "abpcplea";
        findWords(trie, s);

        String rst = "";
        int max = 0;

        for (String cand: cands) {
            if (cand.length() > max) {
                max = cand.length();
                rst = cand;
            }
        }

        System.out.println(rst);
    }

    public static List<String> cands = new ArrayList<String>();

    public static void findWords(Trie trie, String s) {
        HashSet<TrieNode> set = new HashSet<TrieNode>();
        set.add(trie.root);
        for (char c: s.toCharArray()) {
            HashSet<TrieNode> nextNode = new HashSet<>();
            for (TrieNode node: set) {
                if (node.children[c - 'a'] != null) {
                    nextNode.add(node.children[c - 'a']);
                    if (node.children[c - 'a'].val.length() > 0) cands.add(node.children[c - 'a'].val);
                }
            }
            set.addAll(nextNode);
        }
    }

}
