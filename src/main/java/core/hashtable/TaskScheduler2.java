package core.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 2365. Task Scheduler II
 */
public class TaskScheduler2 {
    public static long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long breakDays = 0, workDays = 0, currDay = 0;
        for (int taskId : tasks) {
            if (!map.containsKey(taskId)) {
                workDays++;
                map.put(taskId, currDay++ + space);
            } else {
                if (currDay > map.get(taskId)) {
                    workDays++;
                    map.put(taskId, currDay++ + space);
                } else {
                    long breakPeriod = map.get(taskId) + 1 - currDay;
                    breakDays += breakPeriod;
                    workDays++;
                    currDay += breakPeriod + 1;
                    map.put(taskId, map.get(taskId) + 1 + space);
                }
            }
        }
        return breakDays + workDays;
    }
    // TS: O(N)

    /*
    For the task a,
    we can do it on res + 1 day,
    and it need to be bigger than last[a] + space.
    So this task is completed on max(res, last[a] + space) + 1.
     */
    public long taskSchedulerII2(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long days = 0;
        for (int a : tasks) {
            if (map.containsKey(a)) {
                days = Math.max(days, map.get(a) + space) + 1;
                map.put(a, days);
            } else {
                map.put(a, ++days);
            }
        }
        return days;
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(taskSchedulerII(new int[]{1,2,1,2,3,1}, 3));
    }

}
