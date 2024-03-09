package core.string;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 271. Encode and Decode Strings
 */
public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append(":/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int pos = s.indexOf(":/", i);
            int size = Integer.parseInt(s.substring(i, pos));
            res.add(s.substring(pos + 2, pos + 2 + size));
            i = pos + size + 2;
        }
        return res;
    }
    // TS: O(N)
}
