package com.zem.algorithm.swordoffer2.aboutTrie;

import java.util.Arrays;
import java.util.List;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/4/3 0003 14:44
 */
public class RepalceWord {

    public String repalceWord(String sentence, List<String> dict) {
        Trie trie = buildTrie(dict);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 1; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                if (trie.search(prefix)) {
                    words[i] = prefix;
                }
            }
        }
        return String.join(" ", words);
    }

    private Trie buildTrie(List<String> dict) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        return trie;
    }

    public static void main(String[] args) {
        RepalceWord repalceWord = new RepalceWord();
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        System.out.println(repalceWord.repalceWord("the cattle was rattled by the battery", dict));
    }

}
