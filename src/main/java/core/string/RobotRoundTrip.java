package core.string;

/**
 * https://www.1point3acres.com/bbs/thread-1002332-1-1.html
 * A robot follows instructions to move around.
 * It can move in four different directions:
 * - North
 * - East
 * - South
 * - West
            N 0
            |
       W 3--  --E 1
            |
            S 2
 * There are three different instructions:
 * - F will move the robot forward one step, in the direction it's facing
 * - L will turn the robot counter-clockwise 90 degrees. i.e. if it was facing North, it will now face West
 * - R will turn the robot clockwise 90 degrees, i.e if it was facing North, it will now face East
 *
 * The function isRoundTrip(String instructions) takes as input instructions as string and returns boolean indicating
 * if the robot has made a round trip after following the instructions. Round trip simply means it comes back to
 * where it started.
 * 1. Write Unit tests assuming isRoundTrip is already implemented.
 * 2. Find and fix bugs in the isRoundTrip function
 * 3. All unit tests should pass after fixing the code.
 */
public class RobotRoundTrip {
    public static boolean isRoundTrip(String instructions) {
        int d = 0;
        int[] moves = new int[4];
        for (char c : instructions.toCharArray()) {
            if (c == 'F') {
                moves[d]++;
            } else if (c == 'L') {
                d = (d + 3) % 4;
            } else if (c == 'R') {
                d = (d + 1) % 4;
            }
        }
        return moves[0] == moves[2] && moves[1] == moves[3] && d == 0;
    }

    public static void main(String[] args) {
        System.out.println(isRoundTrip("FFLLFF"));
        System.out.println(isRoundTrip("FFLLFFRR"));
    }

}
