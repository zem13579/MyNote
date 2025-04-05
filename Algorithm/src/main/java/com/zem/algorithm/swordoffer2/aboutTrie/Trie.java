package com.zem.algorithm.swordoffer2.aboutTrie;


import lombok.Data;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/4/3 0003 11:04
 */
@Data
public class Trie {

    static class TrieNode {

        TrieNode[] children;

        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("boy");
        trie.insert("boss");
        System.out.println(trie.search("boy"));
        System.out.println(trie.search("boyy"));
    }
}
