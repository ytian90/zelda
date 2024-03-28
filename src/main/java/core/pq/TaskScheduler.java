package core.pq;

import java.util.*;

/**
 * LC 621. Task Scheduler
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());
        int time = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            int workTime = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    list.add(pq.poll());
                    workTime++;
                }
            }
            for (int c : list) {
                if (--c > 0) {
                    pq.offer(c);
                }
            }
            time += !pq.isEmpty() ? cycle : workTime;
        }
        return time;
    }
    // T: O(N)
    // S: O(1)

    public int leastInterval2(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25] - 1;
        int idle = maxFreq * n;
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idle -= Math.min(maxFreq, freq[i]);
        }
        return idle > 0 ? idle + tasks.length : tasks.length;
    }
    // T: O(N)
    // S: O(1)
}
