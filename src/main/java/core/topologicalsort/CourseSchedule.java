package core.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 207. Course Schedule
 */
public class CourseSchedule {
    // topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        return plan.size() == numCourses;
    }
    // TS: O(N + M), where N is the number of courses and M is the size of prerequisites

    // DFS
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
        int[] visited = new int[numCourses]; // 0 - unvisited, 1 - visited, 2 - completed
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int i, int[] visited) {
        if (visited[i] == 1) {
            return false;
        }
        if (visited[i] == 2) {
            return true;
        }
        visited[i] = 1;
        for (int j : graph.get(i)) {
            if (!dfs(graph, j, visited)) {
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }
    // TS: O(N + M), where N is the number of courses and M is the size of prerequisites
}
