package core.dfs;

/**
 * LC 490. The Maze
 */
public class TheMaze {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] start, int[] end, boolean[][] visited) {
        if (start[0] == end[0] && start[1] == end[1]) {
            return true;
        }
        boolean res = false;
        for (int[] d : dirs) {
            int x = start[0] + d[0], y = start[1] + d[1];
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += d[0];
                y += d[1];
            }
            x -= d[0]; y -= d[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            res = res || dfs(maze, new int[]{x, y}, end, visited);
        }
        return res;
    }
    // TS: O(N * M)

    public static void main(String[] args) {
        TheMaze o = new TheMaze();
        System.out.println(o.hasPath(new int[][]{
                {0,0,0,0,1,0,0},
                {0,0,1,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1},
                {0,1,0,0,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,1,0,0,0,1},
                {0,0,0,0,1,0,0}
        }, new int[]{0,0}, new int[]{8,6}));
    }

}
