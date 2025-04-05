package com.zem.algorithm.huawei2024.ex1.no3197ex1no75;

import java.util.*;

/**
 * 就是普通的便利
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mallocSize = Integer.parseInt(sc.nextLine());
        List<int[]> usedMemory = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            int[] memoryBlock = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            usedMemory.add(memoryBlock);
        }

        if (mallocSize <= 0 || mallocSize > 100) {
            System.out.println(-1);
            return;
        }

        //todo 排序很重要
        usedMemory.sort(Comparator.comparingInt(a -> a[0]));

        int freeSpacestart = 0;
        int bestFitStart = -1;
        int minSizeDiff = Integer.MAX_VALUE;

        for (int[] block : usedMemory) {
            int blockStart = block[0];
            int blockSize = block[1];

            // 下一个blockStart 必须大于 上一个freeSpaceStart
            if (blockStart < freeSpacestart || blockSize <= 0 || blockStart + blockSize > 100) {
                System.out.println(-1);
                return;
            }

            int freeSpace = blockStart - freeSpacestart;
            //todo 这里的<=
            if (mallocSize <= freeSpace && (freeSpace - mallocSize) < minSizeDiff) {
                bestFitStart = freeSpacestart;
                minSizeDiff = freeSpace - mallocSize;
            }
            freeSpacestart = blockStart + blockSize;
        }

        //检查最后一个空闲空间
        //todo 这里的= 号不要忘了
        if (100 - freeSpacestart >= mallocSize && (100 - freeSpacestart - mallocSize) < minSizeDiff) {
            bestFitStart = freeSpacestart;
        }

        System.out.println(bestFitStart);
    }
}
