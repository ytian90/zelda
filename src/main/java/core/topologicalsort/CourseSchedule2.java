package core.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 210. Course Schedule II
 */
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            degree[p[0]]++;
        }
        List<Integer> plan = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                plan.add(i);
            }
        }
        for (int i = 0; i < plan.size(); i++) {
            for (int j : graph.get(plan.get(i))) {
                if (--degree[j] == 0) {
                    plan.add(j);
                }
            }
        }
        return plan.size() == numCourses ? convert(plan) : new int[]{};
    }

    private int[] convert(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    // TS: O(N + M), where N is the number of courses and M is the size of prerequisites
}
