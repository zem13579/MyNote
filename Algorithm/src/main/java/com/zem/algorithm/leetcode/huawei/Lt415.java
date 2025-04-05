package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Lt415 {
    public static void main(String[] args) {
        Lt415 cur = new Lt415();
        System.out.println(cur.addStrings("999", "99"));
    }

    public String addStrings(String num1, String num2) {
        int carryFlag = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || carryFlag != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carryFlag;
            ans.append(sum % 10);
            carryFlag = sum / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();

    }

    public String removeDuplicates(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for(int i = 0;i<s.length();i++){
            Character aChar = s.charAt(i);
            if(queue.peek() != null && queue.peek().equals(aChar)){
                queue.pop();
            }else{
                queue.push(aChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> characterIterator = queue.descendingIterator();
        while (characterIterator.hasNext()){
            sb.append(characterIterator.next());
        }
        return sb.toString();
    }
}
