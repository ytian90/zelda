package core.string;

import java.util.regex.Pattern;

/**
 * LC 468. Validate IP Address
 */
public class ValidateIPAddress {
    String chunkIP4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern patternIP4 = Pattern.compile("^(" + chunkIP4 + "\\.){3}" + chunkIP4 + "$");
    String chunkIP6 = "([0-9a-fA-F]{1,4})";
    Pattern patternIP6 = Pattern.compile("^(" + chunkIP6 + "\\:){7}" + chunkIP6 + "$");

    public String validIPAddress(String queryIP) {
        if (patternIP4.matcher(queryIP).matches()) {
            return "IPv4";
        } else if (patternIP6.matcher(queryIP).matches()) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
    // TS: O(1)
}
