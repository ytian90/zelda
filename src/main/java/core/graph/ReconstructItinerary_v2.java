package core.graph;

import java.util.*;

/**
 * LC 332. Reconstruct Itinerary
 */
public class ReconstructItinerary_v2 {
    // stack/iterative
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        for (List<String> t : tickets) {
            map.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0, stack.pop());
        }
        return res;
    }
    // TS: O(E), where E is the total number of edges.

}
