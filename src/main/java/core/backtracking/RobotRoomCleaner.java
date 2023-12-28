package core.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 489. Robot Room Cleaner
 */
public class RobotRoomCleaner {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        clean(0, 0, 0, new HashSet<>());
    }

    private void clean(int i, int j, int d, Set<String> visited) {
        robot.clean();
        visited.add(i + " " + j);

        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int k = 0; k < 4; k++) {
            int nd = (d + k) % 4;
            int x = i + dirs[nd][0], y = j + dirs[nd][1];
            if (!visited.contains(x + " " + y) && robot.move()) {
                clean(x, y, nd, visited);
                goBack();
            }
            robot.turnRight();
        }
    }

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    // TS: O(N)

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

}
