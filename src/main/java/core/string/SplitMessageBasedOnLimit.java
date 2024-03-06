package core.string;

/**
 * LC 2468. Split Message Based on Limit
 */
public class SplitMessageBasedOnLimit {
    public String[] splitMessage(String message, int limit) {
        int size = message.length();
        int lenOfIndice = 1, total = 1;
        while (size + (3 + len(total)) * total + lenOfIndice > limit * total) {
            if (3 + len(total) * 2 >= limit) {
                return new String[0];
            }
            total++;
            lenOfIndice += len(total);
        }
        return formStrings(message, limit, total);
    }

    private String[] formStrings(String message, int limit, int total) {
        int index = 0;
        String[] res = new String[total];
        for (int i = 1; i <= total; i++) {
            String suffix = String.format("<%d/%d>", i, total);
            String prefix = message.substring(index, Math.min(index + limit - suffix.length(), message.length()));
            res[i - 1] = prefix + suffix;
            index += limit - suffix.length();
        }
        return res;
    }

    private int len(int n) {
        return String.valueOf(n).length();
    }
    // TS: O(N)
}
