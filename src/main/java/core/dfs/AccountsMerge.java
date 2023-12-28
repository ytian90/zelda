package core.dfs;

import java.util.*;

/**
 * LC 721. Accounts Merge
 */
public class AccountsMerge {
    // graph + dfs
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> emailMap = new HashMap<>();
        Map<String, String> emailOwnerMap = new HashMap<>();
        for (List<String> a : accounts) {
            for (int i = 1; i < a.size(); i++) {
                emailOwnerMap.put(a.get(i), a.get(0));
                emailMap.putIfAbsent(a.get(i), new HashSet<>());
                if (i != 1) {
                    emailMap.get(a.get(i)).add(a.get(i - 1));
                    emailMap.get(a.get(i - 1)).add(a.get(i));
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String e : emailMap.keySet()) {
            if (visited.contains(e)) {
                continue;
            }
            List<String> list = new ArrayList<>();
            dfs(emailMap, e, visited, list);
            Collections.sort(list);
            list.add(0, emailOwnerMap.get(e));
            res.add(list);
        }
        return res;
    }

    private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        visited.add(email);
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.contains(next)) {
                continue;
            }
            dfs(graph, next, visited, list);
        }
    }
    // TS: O(N * logN), where N is the total number of accounts

}
