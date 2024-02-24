package core.dfs;

import java.util.*;

/**
 * LC 2092. Find All People With Secret
 */
public class FindAllPeopleWithSecret {
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] m : meetings) {
            adj.putIfAbsent(m[0], new ArrayList<>());
            adj.putIfAbsent(m[1], new ArrayList<>());
            adj.get(m[0]).add(new int[]{m[1], m[2]});
            adj.get(m[1]).add(new int[]{m[0], m[2]});
        }
        // [time, person_id]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, 0});
        pq.add(new int[]{0, firstPerson});
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], person = curr[1];
            if (visited[person]) {
                continue;
            }
            visited[person] = true;
            for (int[] e : adj.getOrDefault(person, new ArrayList<>())) {
                int nextPerson = e[0], nextTime = e[1];
                if (visited[nextPerson] || nextTime < time) {
                    continue;
                }
                pq.add(new int[]{nextTime, nextPerson});
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAllPeople(6, new int[][]{{1,2,5}, {2,3,8}, {1,5,10}}, 1));
        System.out.println(findAllPeople(5, new int[][]{{1,4,3}, {0,4,3}}, 3));
        System.out.println(findAllPeople(12, new int[][]{
                {10,8,6},{9,5,11},{0,5,18},{4,5,13},{11,6,17},{0,11,10},{10,11,7},{5,8,3},{7,6,16},{3,6,10},
                {3,11,1},{8,3,2},{5,0,7},{3,8,20},{11,0,20},{8,3,4},{1,9,4},{10,7,11},{8,10,18}
        }, 9));
    }
}
