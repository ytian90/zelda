package core.array;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 1762. Buildings With an Ocean View
 */
public class BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        int n = heights.length;
        list.add(n - 1);
        int heightestSoFar = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > heightestSoFar) {
                list.add(i);
                heightestSoFar = heights[i];
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[index++] = list.get(i);
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
