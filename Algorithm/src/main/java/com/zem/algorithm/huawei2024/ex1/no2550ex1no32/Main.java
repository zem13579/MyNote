package com.zem.algorithm.huawei2024.ex1.no2550ex1no32;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] heights = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] weights = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(new Student(i + 1, heights[i], weights[i]));
        }
        Collections.sort(students);
        students.forEach(x -> System.out.print(x.no));
    }

    static class Student implements Comparable<Student> {

        int no;
        int height;
        int weight;

        public Student(int no, int height, int weight) {
            this.no = no;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Student student) {
            if (student.height == this.height) {
                return this.weight - student.weight;
            }
            return this.height - student.height;
        }

    }
}
