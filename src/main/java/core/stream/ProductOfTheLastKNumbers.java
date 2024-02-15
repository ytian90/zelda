package core.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 1352. Product of the Last K Numbers
 */
public class ProductOfTheLastKNumbers {
    List<Integer> list;

    public ProductOfTheLastKNumbers() {
        this.list = new ArrayList<>();
        this.list.add(1);
    }

    public void add(int num) {
        if (num > 0) {
            list.add(list.get(list.size() - 1) * num);
        } else {
            list.clear();
            list.add(1);
        }
    }

    public int getProduct(int k) {
        int n = list.size();
        return k < n ? list.get(n - 1) / list.get(n - k - 1) : 0;
    }
    // T: O(1)
    // S: O(N)
}
