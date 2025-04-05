package com.zem.algorithm.swordoffer2.aboutTrie;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
最短的单词编码
 */
public class MinNumLengthEncoding {
    public static void main(String[] args) {
        MinNumLengthEncoding minNumLengthEncoding = new MinNumLengthEncoding();
        System.out.println(minNumLengthEncoding.minNumlengthEncoding(
                new String[]{"time", "me", "bell"}));
    }

    public int minNumlengthEncoding(String[] words) {
        
        List<String> list = Arrays.stream(words).map(StringUtils::reverse).collect(Collectors.toList());
        Trie trie = new Trie();
        for (String rw : list) {
            trie.insert(rw);
        }
        int[] total = {0};
        dsf(trie.getRoot(), 1, total);
        return total[0];
    }

    private void dsf(Trie.TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (Trie.TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dsf(child, length + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += length;
        }

    }
}
