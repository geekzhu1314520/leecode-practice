package trie;

public class TrieNode {

    public boolean endOfWord;
    public char val;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char val) {
        this.val = val;
    }
}

