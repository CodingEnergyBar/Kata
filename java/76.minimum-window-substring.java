/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] source = new int[256];
        int[] target = new int[256];
        for (char c : t.toCharArray()) {
            target[c] += 1;
            // System.out.println("target[c] " + target[c]);
        }

        int l = 0, r = 0; // [l.. r)

        int resl = -1, resr = -1;

        // found one cadidate
        for (; l < s.length(); l++) {
            
            while (r < s.length() && !isValidWindow(source, target)) {
                source[s.charAt(r)]++;
                r++;
            }
            System.out.println(s.substring(l, r));

            if (isValidWindow(source, target)) {
                if (resl == -1 || r - l < resl - resr) {
                    resl = l;
                    resr = r;
                }
            }
            
            // remove from window
            source[s.charAt(l)]--;
            // if(source[s.charAt(l)] == target)
        }

        return s.substring(resl, resr);

    }

    boolean isValidWindow(int[] source, int[] target) {
        for (int i = 0; i < 256; i++) {
            // int cur = i + 'A';

            // System.out.print(source[i] + " " + target[i]);
            // System.out.println();
            if (source[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
