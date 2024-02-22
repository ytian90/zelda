package core.hashtable;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/1555905/square-phone-sock-pairs
 *
 * Sock Pairs
 Question:
 You are given information on a Sock object such as color and foot (left or right). For example, consider the below as input:

 black and left
 pink and right
 pink and left
 black and right
 black and right
 You have to write a method which takes the following input and return the list of Sock object pairs (same color, different foot) which are:

 (1, 4) *OR *(1, 5)
 (2, 3)

 Note if a sock is repeated in a pair then only return 1 pair where that sock is used.
 */
public class SockPairs {
    public static List<int[]> getSockPairs(List<String> input) {
        List<int[]> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            String[] strs = input.get(i).split("\\s+");
            String key = strs[0] + " and " + getMatchName(strs[2]);
            if (map.containsKey(key)) {
                res.add(new int[]{1 + map.get(key) , 1 + i}); // 1 based result
                map.remove(key);
            } else {
                map.put(input.get(i), i);
            }
        }
        return res;
    }

    private static String getMatchName(String name) {
        return "left".equals(name) ? "right" : "left";
    }
    // TS: O(N)

    public static void main(String[] args) {
        for (int[] a : getSockPairs(Arrays.asList("black and left", "pink and right",
                "pink and left", "black and right", "black and right"))) {
            System.out.println(Arrays.toString(a));
        }
    }

}
