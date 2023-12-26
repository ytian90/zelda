package core.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * LC 636. Exclusive Time of Functions
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (String s : logs) {
            Log log = new Log(s);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log prev = stack.pop();
                res[log.id] += log.time - prev.time + 1;
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= log.time - prev.time + 1;
                }
            }
        }
        return res;
    }
    // TS: O(N)

    class Log{
        int id;
        boolean isStart;
        int time;

        public Log(String log) {
            String[] s = log.split(":");
            this.id = Integer.parseInt(s[0]);
            this.isStart = "start".equals(s[1]);
            this.time = Integer.parseInt(s[2]);
        }
    }

}
