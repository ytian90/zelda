package core.pq;

import java.util.*;

/**
 * LC 218. The Skyline Problem
 */
public class TheSkylineProblem {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Point> points = new PriorityQueue<>((a, b) -> (a.x == b.x ? a.y - b.y : a.x - b.x));
        // <height, counter>
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        for (int[] b : buildings) {
            points.add(new Point(b[0], -b[2])); // negative to distinguish start point
            points.add(new Point(b[1], b[2]));
        }
        heights.put(0, 1); // make sure when we check the current height, it has value
        int prevHeight = 0;
        while (!points.isEmpty()) {
            Point point = points.poll();
            if (point.y < 0) { // start
                heights.put(-point.y, heights.getOrDefault(-point.y, 0) + 1);
            } else {
                heights.put(point.y, heights.get(point.y) - 1);
                if (heights.get(point.y) == 0) {
                    heights.remove(point.y);
                }
            }
            int currHeight = heights.lastKey();
            if (currHeight != prevHeight) {
                res.add(Arrays.asList(point.x, currHeight));
                prevHeight = currHeight;
            }
        }
        return res;
    }
    // Time: O(N * logN)
    // Space: O(N)

    public static void main(String[] args) {
        System.out.println(getSkyline(new int[][]{
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        }));

    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
