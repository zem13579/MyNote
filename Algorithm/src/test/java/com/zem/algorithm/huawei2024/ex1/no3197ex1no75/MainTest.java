package com.zem.algorithm.huawei2024.ex1.no3197ex1no75;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class MainTest {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mallocSize = Integer.parseInt(sc.nextLine());

        if (mallocSize > 100 || mallocSize <= 0) {
            System.out.println(-1);
            return;
        }

        List<AssignedBuffer> assignedBuffers = new ArrayList<>();
        while (sc.hasNext()) {
            assignedBuffers.add(new AssignedBuffer(sc.nextInt(), sc.nextInt()));
        }

        //排序很重要
        assignedBuffers.sort(Comparator.comparingInt(x -> x.start));

        int freeSpaceStart = 0;
        int minDiff = Integer.MAX_VALUE;
        int mostSuitAbleStart = -1;
        for (AssignedBuffer assignedBuffer : assignedBuffers) {

            if (freeSpaceStart > assignedBuffer.start || assignedBuffer.end > 100) {
                System.out.println(-1);
                return;
            }

            int freeSpace = assignedBuffer.start - freeSpaceStart;

            if (mallocSize <= freeSpace && freeSpace - mallocSize < minDiff) {
                mostSuitAbleStart = freeSpaceStart;
                minDiff = freeSpace - mallocSize;
            }

            freeSpaceStart = assignedBuffer.end;

        }

        if (100 - freeSpaceStart >= mallocSize && 100 - freeSpaceStart - mallocSize < minDiff) {
            mostSuitAbleStart = freeSpaceStart;
        }

        System.out.println(mostSuitAbleStart);

    }

    static class AssignedBuffer {
        int start;
        int size;

        int end;

        public AssignedBuffer(int statr, int size) {
            this.start = statr;
            this.size = size;
            this.end = statr + size;
        }
    }

}