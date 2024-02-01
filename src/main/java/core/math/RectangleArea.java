package core.math;

/**
 * LC 223. Rectangle Area
 */
public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaOfA = (ay2 - ay1) * (ax2 - ax1);
        int areaOfB = (by2 - by1) * (bx2 - bx1);
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int yOverlap = top - bottom;
        int overlap = 0;
        if (xOverlap > 0 && yOverlap > 0) {
            overlap = xOverlap * yOverlap;
        }
        return areaOfA + areaOfB - overlap;
    }
    // TS: O(1)
}
