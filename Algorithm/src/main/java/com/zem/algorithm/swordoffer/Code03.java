package com.zem.algorithm.swordoffer;

/**
 * 二维数组中的查找
 * https://www.nowcoder.com/share/jump/5635376671693320140907
 */
public class Code03 {
    public static void main(String[] args) {
        Code03 code03 = new Code03();
        int[][] array =
                {
                        {1, 2, 8, 9},
                        {2, 4, 9, 12},
                        {4, 7, 10, 13},
                        {6, 8, 11, 15}
                };
        code03.Find2(7, array);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param target int整型
     * @param array  int整型二维数组
     * @return bool布尔型
     */
    public boolean Find(int target, int[][] array) {
        for (int i = 0, j = array[0].length - 1; i <= array.length - 1 && j >= 0; ) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j = j - 1;
            } else if (array[i][j] < target) {
                i = i + 1;
            }
        }
        return false;
    }

    public boolean Find2(int target, int[][] array) {
        for (int i = array.length - 1, j = 0; i >= 0 && j <= array[0].length - 1; ) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j = j + 1;
            } else if (array[i][j] < target) {
                i = i - 1;
            }
        }
        return false;
    }
}
