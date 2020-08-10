/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {

        int count = 0, pointer = -1;

        for (int i = 0; i < chars.length; i++) {
            count++;

            if (i == chars.length - 1 || (chars[i] != chars[i + 1])) {
                if (count == 1)
                    chars[++pointer] = chars[i]; // Store only the character which has count 1
                else {
                    chars[++pointer] = chars[i]; // Store the character
                    for (char ch : String.valueOf(count).toCharArray())
                        chars[++pointer] = ch; // Store the count of the character
                }
                count = 0;
            }
        }

        return ++pointer;
    }
}
// @lc code=end

