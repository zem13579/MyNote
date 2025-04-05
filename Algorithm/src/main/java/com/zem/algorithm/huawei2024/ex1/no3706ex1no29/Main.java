package com.zem.algorithm.huawei2024.ex1.no3706ex1no29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * todo 算法超时
 */
public class Main {

    private static int m, n;

    private static LinkedList<int[]> horses = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (!line[j].equals(".")) {
                    //马的位置和步数添加到列表中
                    horses.add(new int[]{i, j, Integer.parseInt(line[j])});
                }
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        //定义马的8个方向
        int[][] directions = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

        //初始化最小的步数
        int minSteps = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 初始化当前步数为0
                int steps = 0;
                // 所有马都有可能达到这个位置 先假设可以
                boolean possible = true;

                for (int[] horse : horses) {
                    // 使用队列 进行 bfs
                    Queue<int[]> queue = new LinkedList<>();
                    // 集合已经访问的位置
                    Set<String> visited = new HashSet<>();
                    // 将当前马的位置和步数0加入队列
                    queue.offer(new int[]{horse[0], horse[1], 0});
                    // 已经访问集合中
                    visited.add(horse[0] + "," + horse[1]);

                    boolean found = false;

                    while (!queue.isEmpty() && possible) {
                        int[] current = queue.poll();
                        if (current[0] == i && current[1] == j) {
                            steps += current[2];
                            found = true;
                            break;
                        }

                        //遍历马的8个方向
                        for (int[] direction : directions) {
                            int nx = current[0] + direction[0];
                            int ny = current[1] + direction[1];
                            if (nx >= 0 && nx < m && ny >= 0 && nx < n && current[2] < horse[2] && !visited.contains(nx + "," + ny)) {
                                queue.offer(new int[]{nx, ny, current[2] + 1});
                                visited.add(nx + "," + ny);
                            }
                        }

                    }

                    //如果没能找到目标位置，则标记为不可能到达
                    if (!found) {
                        possible = false;
                    }


                }

                //如果所有马都能找到目标位置，则更新最小步数
                if (possible) {
                    minSteps = Math.min(minSteps, steps);
                }


            }
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
}
