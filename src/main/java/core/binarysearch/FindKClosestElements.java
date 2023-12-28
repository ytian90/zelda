package core.binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 658. Find K Closest Elements
 */
public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] == q.peek() || Math.abs(arr[i] - x) < Math.abs(q.peek() - x)) {
                q.poll();
                q.add(arr[i]);
            } else {
                break;
            }
        }
        return new ArrayList<>(q);
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,1,1,10,10,10}, 1, 9));
    }

}
