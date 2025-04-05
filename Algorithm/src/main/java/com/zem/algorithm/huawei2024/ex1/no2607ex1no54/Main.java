package com.zem.algorithm.huawei2024.ex1.no2607ex1no54;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/9 0009 14:05
 */
public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Deque<Character> sym = new ArrayDeque<>();
        Deque<Integer> numbers = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; ) {
            char c = charArray[i];
            if (c == '#' || c == '$') {
                sym.push(c);
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(c)) {
                    sb.append(c);
                    if (++i >= charArray.length) {
                        break;
                    }
                    c = charArray[i];
                }
                int theNum = Integer.parseInt(sb.toString());
                if (!sym.isEmpty() && sym.peek() == '#') {
                    int result = cal1(numbers.pop(), theNum);
                    numbers.push(result);
                    sym.pop();
                } else {
                    numbers.push(theNum);
                }
            }
        }
        while (!sym.isEmpty()) {
            int x = numbers.pollLast();
            int y = numbers.pollLast();
            int result = cal2(x, y);
            numbers.addLast(result);
            sym.pop();
        }
        
        System.out.println(numbers.getFirst());
        
    }
    
    
    private static int cal1(int x, int y) {
        return 4 * x + 3 * y + 2;
    }
    
    private static int cal2(int x, int y) {
        return 2 * x + y + 3;
    }
    
}
