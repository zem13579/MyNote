package com.zem.algorithm.leetcode.everyDay;

import java.util.Arrays;

public class Lt2214 {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0, 0, 1, 2, 1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        atm.deposit(new int[]{0, 1, 0, 1, 1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(550)));
    }

    public static class ATM {

        private int[] cnt = new int[5];
        private int[] value = new int[]{20, 50, 100, 200, 500};

        public ATM() {

        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                cnt[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] res = new int[5];
            for (int i = cnt.length - 1; i >= 0; i--) {
                res[i] = (int) Math.min(cnt[i], amount / value[i]);
                amount -= res[i] * value[i];
            }
            if (amount > 0) {
                return new int[]{-1};
            }
            for (int i = 0; i < cnt.length; i++) {
                cnt[i] -= res[i];
            }
            return res;
        }
    }

}
