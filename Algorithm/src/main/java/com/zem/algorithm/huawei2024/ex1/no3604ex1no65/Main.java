package com.zem.algorithm.huawei2024.ex1.no3604ex1no65;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/12 0012 17:10
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] tmp = new int[arr.length + 1];
        System.arraycopy(arr, 0, tmp, 1, arr.length);
        System.out.println(dfs(tmp, 1));
    }
    
    private static int dfs(int[] arr, int index) {
        if (index > arr.length - 1 || arr[index] == -1) {
            return 0;
        }
        return arr[index] + Math.max(dfs(arr, 2 * index), dfs(arr, 2 * index + 1));
    }
    
}
