package core.graph;

import java.util.*;

/**
 * LC 332. Reconstruct Itinerary
 */
public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets) {
            map.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }
        dfs("JFK");
        return path;
    }

    private void dfs(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            dfs(map.get(airport).poll());
        }
        path.add(0, airport);
    }
    // TS: O(E), where E is the total number of edges.

    /*
           >  B >
         D   <-   C
         ^        ^
         JFK ->   A
         besides, D -> A, C -> JFK

      From JFK we first visit JFK -> A -> C -> D -> A. There we're stuck, so we write down A as the end of the route
      and retreat back to D. There we see the unused ticket to B and follow it: D -> B -> C -> JFK -> D.
      Then we're stuck again, retreat and write down the airports while doing so: Write down D before the already
      written A, then JFK before the D, etc. When we're back from our cycle at D, the written route is
      D -> B -> C -> JFK -> D -> A. Then we retreat further along the original path, prepending C, A and
      finally JFK to the route, ending up with the route JFK -> A -> C -> D -> B -> C -> JFK -> D -> A.
     */

}
