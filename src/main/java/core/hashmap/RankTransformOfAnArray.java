package core.hashmap;

import java.util.*;

/**
 * LC 1331. Rank Transform of an Array
 */
public class RankTransformOfAnArray {
    public static int[] arrayRankTransform(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);
        Arrays.sort(a);
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i : a) {
            rank.putIfAbsent(i, rank.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            a[i] = rank.get(arr[i]);
        }
        return a;
    }
    // T: O(N * logN)
    // S: O(N)

    public static int[] arrayRankTransform2(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Arrays.sort(arr);
        int[] res = new int[arr.length];
        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            for (int j : map.get(arr[i])) {
                if (res[j] == 0) {
                    res[j] = rank;
                }
            }
            rank++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{100, 100, 100})));
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})));
    }
}
