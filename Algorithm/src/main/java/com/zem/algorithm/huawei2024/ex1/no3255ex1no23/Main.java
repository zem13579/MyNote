package com.zem.algorithm.huawei2024.ex1.no3255ex1no23;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/4 0004 16:37
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            System.out.println(check(split) + " ");
        }
    }
    
    private static boolean check(String[] split) {
        //- 缺勤不超过一次
        //
        //- 没有连续的迟到/早退
        //
        //- 任意连续7次考勤，缺勤/迟到/早退不超过3次
        //absent：缺勤
        //
        //late：迟到
        //
        //leaveearly：早退
        //
        //present：正常上班
        Stack<Integer> absentStack = new Stack<>();
        Stack<Integer> lateStack = new Stack<>();
        Stack<Integer> leaveearlyStack = new Stack<>();
        
        for (int i = 0; i < split.length; i++) {
            if ("absent".equals(split[i])) {
                absentStack.push(i);
                if (absentStack.size() > 1) {
                    return false;
                }
            } else if ("late".equals(split[i])) {
                if (!lateStack.isEmpty() && lateStack.peek() + 1 == i) {
                    return false;
                } else {
                    lateStack.push(i);
                }
            } else if ("leaveearly".equals(split[i])) {
                if (!leaveearlyStack.isEmpty() && leaveearlyStack.peek() + 1 == i) {
                    return false;
                } else {
                    leaveearlyStack.push(i);
                }
            }
        }
        
        return check2(absentStack) && check2(lateStack) && check2(leaveearlyStack);
    }
    
    private static boolean check2(Stack<Integer> stack) {
        if (stack.size() > 2) {
            Integer last = stack.pop();
            while (!stack.isEmpty()) {
                Integer cur = stack.pop();
                if (last - cur < 7) {
                    return false;
                }
                last = cur;
            }
        }
        return true;
    }
}
