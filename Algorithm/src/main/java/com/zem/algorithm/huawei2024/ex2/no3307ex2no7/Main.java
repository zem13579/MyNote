package com.zem.algorithm.huawei2024.ex2.no3307ex2no7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * todo 这个只有 70分
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int requireMonth = Integer.parseInt(sc.nextLine());
        int[] requirements = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(requirements);

        int leastNeed = requirements[requirements.length - 1];

        for (int humResource = leastNeed; ; humResource++) {
            int count = 0;
            int tmp = 0;
            for (int j = 0; j < requirements.length; j++) {
                int requirement = requirements[j];
                if (tmp + requirement <= humResource) {
                    tmp += requirement;
                    continue;
                }
                count++;
                if (count > requireMonth) {
                    break;
                }
                tmp = requirement;
            }
            if (tmp != 0) {
                count++;
            }
            if (count <= requireMonth) {
                System.out.println(humResource);
                break;
            }
        }
    }
}
