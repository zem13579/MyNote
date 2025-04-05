package com.zem.algorithm.swordoffer2.aboutint;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Describe 输入一个整数数组，数组中只有一个数字出现了一次，而其他数字都出现了3次。
 * 请找出那个只出现一次的数字。例如，如果输入的数组为[0，1，0，1，0，1，100]，则只出现一次的数字是100。
 * @Author zem
 * @CreateDate 2024/2/8 0008 16:34
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 1, 100};
        System.out.println(new SingleNumber().singleNumber(arr));

    }

    /**
     * @param appearTime
     * @return
     */
    public int[] genArray(int appearTime) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int singleNumber = RandomUtils.nextInt(1, 1000);
        arrayList.add(singleNumber);
        int otherNumverCnt = RandomUtils.nextInt(5, 10);
        for (int i = 0; i < otherNumverCnt; i++) {
            for (int j = 0; j < appearTime; j++) {
                int otherNumber = RandomUtils.nextInt(1, 100);
                arrayList.add(otherNumber);
            }
        }
        Collections.shuffle(arrayList);
        return null;
    }

    public int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }
        return result;
    }
}
