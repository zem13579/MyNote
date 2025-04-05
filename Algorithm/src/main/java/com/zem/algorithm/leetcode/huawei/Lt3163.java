package com.zem.algorithm.leetcode.huawei;

public class Lt3163 {
    public static void main(String[] args) {
        Lt3163 lt3163 = new Lt3163();
        System.out.println(lt3163.compressedString("aaaaaaaaaaaaaabb"));
    }

    public String compressedString(String word) {
        char[] charArray = word.toCharArray();
        Character last = null;
        int counter = 0;
        StringBuilder comp = new StringBuilder();
        for (char c : charArray) {
            if (last == null) {
                counter++;
                last = c;
            } else if (last.equals(c)) {
                if (counter == 9) {
                    comp.append(counter);
                    comp.append(last);
                    counter = 1;
                } else {
                    counter++;
                }

            } else {
                comp.append(counter);
                comp.append(last);
                last = c;
                counter = 1;
            }
        }
        if (counter > 0) {
            comp.append(counter);
            comp.append(last);
        }
        return comp.toString();
    }
}
