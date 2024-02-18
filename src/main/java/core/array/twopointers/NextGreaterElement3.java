package core.array.twopointers;

/**
 * LC 556. Next Greater Element III
 */
public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
        char[] nums = ("" + n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            return -1;
        }
        int j = nums.length - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        try {
            return Integer.parseInt(String.valueOf(nums));
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char[] nums, int i, int j) {
        char c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }

    private void reverse(char[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    // TS: O(N)
}
