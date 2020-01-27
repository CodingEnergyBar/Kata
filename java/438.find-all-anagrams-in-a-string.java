import java.nio.channels.NetworkChannel;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[256];
        int[] source = new int[256];

        int l = 0, r = p.length() - 1;
        List<Integer> res = new ArrayList<>();

        if (r >= s.length())
            return res;

        // initialize the first s[0...pLen)
        int i = 0;
        for (char c : p.toCharArray()) {
            target[c]++;
            source[s.charAt(i++)]++;
        }
        if (isAnagrams(target, source)) {
            res.add(0);
        }

        while (l < s.length() - p.length()) {
            if (r + 1 < s.length()) {
                source[s.charAt(++r)]++;
                // source[s.charAt(l)]--;
                source[s.charAt(l++)]--;

                // System.out.println(s.substring(l, r + 1));

                if (target[s.charAt(r)] != 0 && isAnagrams(source, target))
                    res.add(l);

            }
        }

        return res;

    }

    boolean isAnagrams(int[] source, int[] target) {
        // System.out.print(source['a']);
        // System.out.print(source['b']);
        // System.out.print(source['c']);
        // System.out.println();
        // System.out.print(target['a']);
        // System.out.print(target['b']);
        // System.out.print(target['c']);
        // System.out.println();

        for (int i = 0; i < 26; i++) {
            int c = i + 'a';
            if (source[c] != target[c])
                return false;
        }
        return true;

    }
}
// @lc code=end
