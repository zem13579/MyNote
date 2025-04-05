package com.zem.algorithm.swordoffer2.aboutTrie;


/**
 * 面试题66：单词之和
 */
public class MapSum {
    static class TrieNode {
        private TrieNode[] children;
        private int value; //每个单词对应的值

        public TrieNode() {
            this.children = new TrieNode[26];
        }

    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.value = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch = 'a'] == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return getSum(node);
    }

    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        int value = node.value;
        for (TrieNode child : node.children) {
            value += getSum(child);
        }
        return value;
    }
}
