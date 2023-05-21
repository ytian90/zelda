package core.dp;

/**
 * LC 121. Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, res = 0;
        for (int p : prices) {
            res = Math.max(res, p - min);
            min = Math.min(min, p);
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
