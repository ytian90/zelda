package core.dfs;

/**
 * LC 50. Pow(x, n)
 */
public class Pow {
    public double myPow(double x, int n) {
        return pow(x, (long) n);
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / pow(x, -n);
        }

        if (n % 2 == 1) {
            return x * pow(x * x, (n - 1) / 2);
        } else {
            return pow(x * x, n / 2);
        }
    }
    // TS: O(logN)
}
