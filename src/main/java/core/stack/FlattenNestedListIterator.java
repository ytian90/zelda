package core.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * LC 341. Flatten Nested List Iterator
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        prepare(nestedList);
    }
    // TS: O(N), where N is the size of the list

    private void prepare(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        return null;
    }
    // TS: O(1)

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }
            prepare(stack.pop().getList());
        }
        return false;
    }
    // TS: O(1)

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
