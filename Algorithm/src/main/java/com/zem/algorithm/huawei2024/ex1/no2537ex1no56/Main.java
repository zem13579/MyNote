package com.zem.algorithm.huawei2024.ex1.no2537ex1no56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/9 0009 15:17
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(Arrays.asList(x, y));
        }
        
        long area = 0;
        int height = arr.get(0).get(1);
        int x = arr.get(0).get(0);
        for (int i = 1; i < arr.size(); i++) {
            List<Integer> cur = arr.get(i);
            List<Integer> last = arr.get(i - 1);
            area += Math.abs(height * (cur.get(0) - last.get(0)));
            height += cur.get(1);
            x = cur.get(0);
        }
        
        while (x < E) {
            area += Math.abs(height);
            x++;
        }
        
        System.out.println(area);
        
        
    }
    
}
