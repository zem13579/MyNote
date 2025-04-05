package com.zem.algorithm.huawei2024.ex1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/12 0012 16:45
 */
public class No64 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] number = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int jump = sc.nextInt();
        int left = sc.nextInt();
        
        if (number.length <= left) {
            int sum = 0;
            for (int i : number) {
                sum += i;
            }
            System.out.println(sum);
            return;
        }
        
        int jcount = 0;
        int lefted = number.length;
        int[] deleteTag = new int[number.length];
        for (int i = 1; i < number.length; i = (i + 1) % number.length) {
            if (jcount == jump && deleteTag[i] == 0) {
                jcount = 0;
                deleteTag[i] = 1;
                lefted--;
                if (lefted == left) {
                    int sum = 0;
                    for (int j = 0; j < number.length; j++) {
                        if (deleteTag[j] == 0) {
                            sum += number[j];
                        }
                    }
                    System.out.println(sum);
                    return;
                }
            }
            if (deleteTag[i] == 0) {
                jcount++;
            }
            
        }
        
    }
    
}
