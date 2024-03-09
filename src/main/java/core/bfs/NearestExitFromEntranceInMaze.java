package core.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1926. Nearest Exit from Entrance in Maze
 */
public class NearestExitFromEntranceInMaze {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[entrance[0]][entrance[1]] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] c = q.poll();
                if (maze[c[0]][c[1]] == '.' && (c[0] == 0 || c[0] == n - 1 || c[1] == 0 || c[1] == m - 1)) {
                    if (!(c[0] == entrance[0] && c[1] == entrance[1])) {
                        return steps;
                    }
                }
                for (int[] d : dirs) {
                    int x = c[0] + d[0], y = c[1] + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || maze[x][y] == '+' || visited[x][y]) {
                        continue;
                    }
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
            steps++;
        }
        return -1;
    }
    // TS: O(N * M)
}
