package com.zem.algorithm.huawei2024.ex1.no2819ex1no40;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3
 * hello
 * world
 * cloud
 * welldonehohneyr
 *
 * 3
 * apple
 * car
 * window
 * welldoneapplec?
 */
class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfWords = Integer.parseInt(sc.nextLine());
        String[] words = new String[numOfWords];
        for (int i = 0; i < numOfWords; i++) {
            words[i] = sc.nextLine();
        }

        int[] charCount = new int[26];
        int allType = 0;
        char[] charArray = sc.nextLine().toCharArray();
        for (char c : charArray) {
            if (c != '?') {
                charCount[c - 'a']++;
            } else {
                allType++;
            }
        }

        int learnWord = words.length;
        for (int i = 0; i < words.length; i++) {
            int[] charCountCopy = Arrays.copyOf(charCount, charCount.length);
            int allTypeCopy = allType;
            String cur = words[i];
            char[] curCharArray = cur.toCharArray();
            for (char c : curCharArray) {
                if (charCountCopy[c - 'a'] > 0) {
                    charCountCopy[c - 'a']--;
                } else if (allTypeCopy > 0) {
                    allTypeCopy--;
                } else {
                    learnWord--;
                    break;
                }
            }

        }
        System.out.println(learnWord);

    }
}