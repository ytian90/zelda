package core.graph.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LC 499. The Maze III
 */
public class TheMaze3 {
    int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    String[] textDirs = new String[]{"l", "u", "r", "d"};

    class State {
        int row;
        int col;
        int distance;
        String path;

        public State(int row, int col, int distance, String path) {
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.path = path;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> (a.distance == b.distance ?
                a.path.compareTo(b.path) : a.distance - b.distance));
        pq.add(new State(ball[0], ball[1], 0, ""));
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int i = curr.row, j = curr.col, d = curr.distance;
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (i == hole[0] && j == hole[1]) {
                return curr.path;
            }
            for (State next : getNeighbors(i, j, maze, hole)) {
                pq.add(new State(next.row, next.col, curr.distance + next.distance, curr.path + next.path));
            }
        }
        return "impossible";
    }

    private List<State> getNeighbors(int row, int col, int[][] maze, int[] hole) {
        List<State> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int dx = dirs[i][0], dy = dirs[i][1];
            String dt = textDirs[i];
            int x = row, y = col, dist = 0;
            while (valid(x + dx, y + dy, maze)) {
                x += dx;
                y += dy;
                dist++;
                if (x == hole[0] && y == hole[1]) {
                    break;
                }
            }
            res.add(new State(x, y, dist, dt));
        }
        return res;
    }

    private boolean valid(int i, int j, int[][] maze) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze[0].length) {
            return false;
        }
        return maze[i][j] == 0;
    }

    public static void main(String[] args) {
        TheMaze3 o = new TheMaze3();
        System.out.println(o.findShortestWay(new int[][]{{0,0,0,0,0}, {1,1,0,0,1}, {0,0,0,0,0}, {0,1,0,0,1}, {0,1,0,0,0}},
                new int[]{4,3}, new int[]{0,1}));
    }


}
