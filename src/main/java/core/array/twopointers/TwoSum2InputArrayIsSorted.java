package core.array.twopointers;

/**
 * LC 167. Two Sum II - Input Array Is Sorted
 */
public class TwoSum2InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
    // T: O(N)
    // S: O(1)
}
