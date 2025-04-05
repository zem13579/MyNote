package com.zem.algorithm.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;

public class Lt207 {

    List<List<Integer>> edges;
    int[] status;
    boolean valid = true;

    public static void main(String[] args) {
        Lt207 lt207 = new Lt207();
        System.out.println(lt207.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        status = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                this.dfs(i);
            }
        }

        return valid;

    }

    private void dfs(int u) {
        status[u] = 1;
        for (Integer v : edges.get(u)) {
            if (status[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (status[v] == 1) {
                valid = false;
                return;
            }
        }
        status[u] = 2;
    }

}
