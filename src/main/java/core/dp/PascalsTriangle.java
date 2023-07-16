package core.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 118. Pascal's Triangle
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        if (numRows == 1) {
            return res;
        }
        res.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return res;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 1; j < res.get(i - 1).size(); j++) {
                next.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            next.add(1);
            res.add(next);
        }
        return res;
    }
    // TS: O(N ^ 2), where N is the numRows
}
