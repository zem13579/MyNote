package com.zem.algorithm.huawei2024.ex1.no3206ex1no8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flawNum = Integer.parseInt(scanner.nextLine());
        String rawStr = scanner.nextLine();
        Character[] dict = {'a', 'e', 'i', 'o', 'u'};
        List<Character> dictList = Arrays.stream(dict).toList();

        char[] charArray = rawStr.toCharArray();
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (dictList.contains(charArray[i])) {
                indexs.add(i);
            }
        }

        int maxLength = 0;
        for (int start = 0, end = 1; start < indexs.size() && end < indexs.size(); ) {
            int flaw = indexs.get(end) - indexs.get(start) - (end - start);
            if (flaw > flawNum) {
                start++;
            } else if (flaw == flawNum) {
                if(flaw>maxLength){
                    maxLength = flaw;
                }
            } else {
                end++;
            }

        }

        System.out.println(maxLength);
    }

}