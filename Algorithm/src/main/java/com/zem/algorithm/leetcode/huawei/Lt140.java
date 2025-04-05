package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;

public class Lt140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        List<String> curWords = new ArrayList<>();
        this.traceBack(s, 0, wordDict, curWords, ans);
        return ans;
    }

    private void traceBack(String s, int i, List<String> wordDict, List<String> curWords, List<String> ans) {
        if (i == s.length()) {
            String join = String.join(" ", curWords);
            ans.add(join);
            return;
        }

        for (int k = i; k <= s.length(); k++) {
            String substring = s.substring(i, k);
            if (wordDict.contains(substring)) {
                curWords.add(substring);
                traceBack(s, k, wordDict, curWords, ans);
                curWords.remove(curWords.size() - 1);
            }
        }

    }
}
