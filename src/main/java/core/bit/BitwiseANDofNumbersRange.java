package core.bit;

/**
 * LC 201. Bitwise AND of Numbers Range
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int i = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            i++;
        }
        return left << i;
    }
    // TS: O(1)
}
