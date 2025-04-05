package com.zem.algorithm.leetcode.learn.part2TowDArray;

public class Lt289 {
    public void gameOfLife(int[][] board) {
        int length = board.length;
        int width = board[0].length;
        int[][] copy = new int[length][width];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i],0,copy[i],0,board[i].length);
        }
        int[][] directArr = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int liveNum = 0;
                for (int[] direct : directArr) {
                    int row = i + direct[0];
                    int col = j + direct[1];
                    if (row >= 0 && row < length && col >= 0 && col < width) {
                        if (copy[row][col] == 1) {
                            liveNum++;
                        }
                    }
                }
                if (copy[i][j] == 1) {
                    if (liveNum < 2 || liveNum > 3) {
                        board[i][j] = 0;
                    }
                } else if (liveNum == 3) {
                    board[i][j] = 1;
                }

            }
        }

    }

    public static void main(String[] args) {
        Lt289 lt289 = new Lt289();
        lt289.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }

}
