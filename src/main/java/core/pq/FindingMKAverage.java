package core.pq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * LC 1825. Finding MK Average
 */
public class FindingMKAverage {
    TreeMap<Integer, Integer> top = new TreeMap<>(), middle = new TreeMap<>(), bottom = new TreeMap<>();
    Queue<Integer> q = new LinkedList<>();
    long middleSum;
    int m, k;
    int topCount, bottomCount;

    public FindingMKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    // T: O(logN)
    public void addElement(int num) {
        if (q.size() == m) {
            int pop = q.poll();
            if (top.containsKey(pop)) {
                remove(top, pop);
                topCount--;
            } else if (middle.containsKey(pop)) {
                remove(middle, pop);
                middleSum -= pop;
            } else if (bottom.containsKey(pop)){
                remove(bottom, pop);
                bottomCount--;
            }
        }
        add(middle, num);
        q.offer(num);
        middleSum += num;
        while (topCount < k && !middle.isEmpty()) {
            topCount++;
            middleSum -= middle.lastKey();
            add(top, remove(middle, middle.lastKey()));
        }
        while (!middle.isEmpty() && !top.isEmpty() && top.firstKey() < middle.lastKey()) {
            middleSum += top.firstKey();
            add(middle, remove(top, top.firstKey()));
            middleSum -= middle.lastKey();
            add(top, remove(middle, middle.lastKey()));
        }
        while (bottomCount < k && !middle.isEmpty()) {
            bottomCount++;
            middleSum -= middle.firstKey();
            add(bottom, remove(middle, middle.firstKey()));
        }
        while (!middle.isEmpty() && !bottom.isEmpty() && bottom.lastKey() > middle.firstKey()) {
            middleSum += bottom.lastKey();
            add(middle, remove(bottom, bottom.lastKey()));
            middleSum -= middle.firstKey();
            add(bottom, remove(middle, middle.firstKey()));
        }
    }

    private int remove(TreeMap<Integer, Integer> map, int n) {
        map.put(n, map.get(n) - 1);
        if (map.get(n) == 0) {
            map.remove(n);
        }
        return n;
    }

    private void add(TreeMap<Integer, Integer> map, int n) {
        map.put(n, map.getOrDefault(n, 0) + 1);
    }

    // T: O(1)
    public int calculateMKAverage() {
        return q.size() == m ? (int) (middleSum / (m - 2 * k)) : -1;
    }

}
