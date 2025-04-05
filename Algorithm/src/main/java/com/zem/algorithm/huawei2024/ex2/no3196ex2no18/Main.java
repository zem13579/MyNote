package com.zem.algorithm.huawei2024.ex2.no3196ex2no18;

import java.util.Scanner;

/**
 * todo 感觉有点怪 14 14 这种合理吗 14开始，14点结束 那不就没开吗。。。。
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        timeDuration[] ocupiedTime = new timeDuration[25];
        for (int i = 0; i < num; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            for (int j = start; j <= end; j++) {
                ocupiedTime[j] = new timeDuration();
                if (j == start) {
                    ocupiedTime[j].start = true;
                } else if (j == end) {
                    ocupiedTime[j].end = true;
                } else {
                    ocupiedTime[j].start = true;
                    ocupiedTime[j].end = true;
                }

            }
        }


        for (int i = 1; i < ocupiedTime.length; i++) {
            timeDuration duration = ocupiedTime[i];
            if (duration.start && !duration.end) {
                int start = i;
                int end = i + 1;
                while (end < ocupiedTime.length && ocupiedTime[end].start && ocupiedTime[end].end) {
                    end++;
                }
                System.out.println(start + " " + end);
                i = end;
            }
        }
    }

    static class timeDuration {
        boolean start;
        boolean end;

        boolean ocupied = start && end;
    }


}
