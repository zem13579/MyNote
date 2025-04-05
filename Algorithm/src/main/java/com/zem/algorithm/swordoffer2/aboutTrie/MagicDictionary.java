package com.zem.algorithm.swordoffer2.aboutTrie;

public class MagicDictionary {
    Trie.TrieNode root;

    public MagicDictionary() {
        root = new Trie.TrieNode();
    }

    public boolean search(String word) {
        return dfs(root, word, 0, 0);
    }

    private boolean dfs(Trie.TrieNode root, String word, int i, int edit) {
        if (root == null) {
            return false;
        }
        if (root.isWord && i == word.length() && edit == 1) {
            return true;
        }
        if (i < word.length() && edit <= 1) {
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(i) - 'a' ? edit : edit + 1;
                found = dfs(root.children[j], word, i + 1, next);
            }
            return found;
        }
        return false;
    }
}
