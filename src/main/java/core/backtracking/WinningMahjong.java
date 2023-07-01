package core.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.1point3acres.com/bbs/thread-1002363-1-1.html
 * https://leetcode.com/discuss/interview-question/1921572/find-if-it-is-a-winning-hand-in-mahjong
 */
public class WinningMahjong {
    public static List<Integer> winningTiles(List<Integer> input) {
        if (input.size() != 13) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(input);
        for (int i = 1; i <= 9; i++) {
            list.add(i);
            if (isWinningHand(list)) {
                res.add(i);
            }
            list.remove(list.size() - 1);
        }
        return res;
    }

    public static boolean isWinningHand(List<Integer> hand) {
        if (hand.size() > 14) {
            return false;
        }
        int[] cards = new int[10];
        for (int j : hand) {
            cards[j]++;
        }
        return helper(cards, 0, 0);
    }

    private static boolean helper(int[] cards, int pairCount, int tripletCount) {
        if (pairCount > 1 || tripletCount > 4) {
            return false;
        }
        if (pairCount == 1 && tripletCount == 4) {
            return true;
        }
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == 0) {
                continue;
            }
            if (cards[i] >= 3) {
                cards[i] -= 3;
                if (helper(cards, pairCount, tripletCount + 1)) {
                    return true;
                }
                cards[i] += 3;
            }
            if (cards[i] >= 2) {
                cards[i] -= 2;
                if (helper(cards, pairCount + 1, tripletCount)) {
                    return true;
                }
                cards[i] += 2;
            }
            if (i + 2 <= 9 && cards[i] >= 1 && cards[i + 1] >= 1 && cards[i + 2] >= 1) {
                cards[i]--;
                cards[i + 1]--;
                cards[i + 2]--;
                if (helper(cards, pairCount, tripletCount + 1)) {
                    return true;
                }
                cards[i]++;
                cards[i + 1]++;
                cards[i + 2]++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isWinningHand(Arrays.asList(1,1,2,2,3,3,4,4,5,5,5,9,9,9)));
        System.out.println(isWinningHand(Arrays.asList(1,1,1,2,2,3,4,5,6,7,8,9,9,9)));
        System.out.println(winningTiles(Arrays.asList(1,1,1,6,6,6,7,7,8,8,8,9,9)));

    }

}
