package com.zem.algorithm.huawei2024.ex1.no2535ex1no62;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/12 0012 14:42
 */
public class Main {
    
    static class Point {
        
        public int row;
        
        public int col;
        
        public int tag;
        
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        
        @Override
        public String toString() {
            return row + " " + col;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            points.add(new Point(arr[i], arr[i + 1]));
        }
        for (int i = 2; i < points.size(); i++) {
            Point beforeLast = points.get(i - 2);
            Point last = points.get(i - 1);
            Point cur = points.get(i);
            if (cur.row == beforeLast.row && cur.row == last.row) {
                last.tag = 1;
            } else if (cur.col == last.col && cur.col == beforeLast.col) {
                last.tag = 1;
            } else {
                int diffrow1 = cur.row - last.row;
                int diffcol1 = cur.col - last.col;
                int diffrow2 = last.row - beforeLast.row;
                int diffcol2 = last.col - beforeLast.col;
                if (diffrow1 == diffrow2 && diffcol1 == diffcol2) {
                    last.tag = 1;
                }
            }
        }
        points.stream().filter(x -> x.tag == 0).forEach(x -> System.out.print(x + " "));
    }
}
