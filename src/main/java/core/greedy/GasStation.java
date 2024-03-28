package core.greedy;

/**
 * LC 134. Gas Station
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0, currGain = 0, res = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGain += gas[i] - cost[i];
            currGain += gas[i] - cost[i];
            if (currGain < 0) {
                res = i + 1;
                currGain = 0;
            }
        }
        return totalGain >= 0 ? res : -1;
    }
    // T: O(N)
    // S: O(1)
}
