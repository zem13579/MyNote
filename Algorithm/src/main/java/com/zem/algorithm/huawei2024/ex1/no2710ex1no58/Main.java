package com.zem.algorithm.huawei2024.ex1.no2710ex1no58;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/12 0012 10:36
 */
public class Main {
    
    static class Point {
        
        public int row;
        
        public int col;
        
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return row == point.row && col == point.col;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
        
        public List<Point> getAround() {
            List<Point> result = new ArrayList<>();
            if (row - 1 > -1) {
                result.add(new Point(row - 1, col));
            }
            if (col - 1 > -1) {
                result.add(new Point(row, col - 1));
            }
            if (row + 1 < 19) {
                result.add(new Point(row + 1, col));
            }
            if (col + 1 < 19) {
                result.add(new Point(row, col + 1));
            }
            return result;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Point> black = new ArrayList<>();
        String[] split = sc.nextLine().split(" ");
        for (int i = 0; i < split.length; i = i + 2) {
            black.add(new Point(Integer.parseInt(split[i]), Integer.parseInt(split[i + 1])));
        }
        List<Point> white = new ArrayList<>();
        split = sc.nextLine().split(" ");
        for (int i = 0; i < split.length; i = i + 2) {
            white.add(new Point(Integer.parseInt(split[i]), Integer.parseInt(split[i + 1])));
        }
        
        List<Point> blackQI = new ArrayList<>();
        for (Point point : black) {
            List<Point> around = point.getAround();
            for (Point point1 : around) {
                if (!black.contains(point1) && !white.contains(point1) && !blackQI.contains(point1)) {
                    blackQI.add(point1);
                }
            }
        }
        
        List<Point> whiteQI = new ArrayList<>();
        for (Point point : white) {
            List<Point> around = point.getAround();
            for (Point point1 : around) {
                if (!black.contains(point1) && !white.contains(point1) && !whiteQI.contains(point1)) {
                    whiteQI.add(point1);
                }
            }
        }
        
        System.out.println(blackQI.size() + " " + whiteQI.size());
    }
    
}
