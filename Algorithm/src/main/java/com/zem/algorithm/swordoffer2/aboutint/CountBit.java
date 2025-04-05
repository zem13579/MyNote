package com.zem.algorithm.swordoffer2.aboutint;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/2/8 0008 15:13
 */
public class CountBit {
    public static void main(String[] args) throws InterruptedException {
        CountBit countBit = new CountBit();
        Thread thread = new Thread(() -> {
            long start = System.currentTimeMillis();
            countBit.countBits(100000);
            System.out.println("countBits\t" + (System.currentTimeMillis() - start));
        }
        );
        thread.start();
        thread.join();
        Thread thread1 = new Thread(() -> {
            long start = System.currentTimeMillis();
            countBit.countBits2(100000);
            System.out.println("countBits2\t" + (System.currentTimeMillis() - start));
        }
        );
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(() -> {
            long start = System.currentTimeMillis();
            countBit.countBits3(100000);
            System.out.println("countBits3\t" + (System.currentTimeMillis() - start));
        }
        );
        thread2.start();
        thread2.join();

    }


    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i < num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }

    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i < num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    public int[] countBits3(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i < num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
