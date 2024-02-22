package core.hashtable;

/**
 * LC 383. Ransom Note
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    // T: O(N), N is the total number of letters in ransomNote and magazine
    // S: O(1)
}
