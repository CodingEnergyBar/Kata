/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */

public class Solution {
    /**
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // write your code here
        // " -- (+-)3.6(e(+-)3)"
        s = s.trim() + " ";
        char[] arr = s.toCharArray();
        System.out.println("arr " + Arrays.toString(arr));
        int len = arr.length;

        int i = 0;
        if (arr[i] == '-' || arr[i] == '+') {
            i++;
        }
        int nPoint = 0, nDigits = 0;
        while (Character.isDigit(arr[i]) || arr[i] == '.') {

            if (Character.isDigit(arr[i])) {
                nDigits++;
            } else {
                nPoint++;
            }
            i++;
        }
        // .4, 4.???, 2.3
        if (nPoint > 1 || nDigits < 1) {

            return false;
        }
        if (arr[i] == 'e') {
            i++;
            if (arr[i] == '+' || arr[i] == '-') {
                i++;
            }
            if (!Character.isDigit(arr[i])) {
                return false;
            }
        }

        while (Character.isDigit(arr[i])) {
            i++;
        }

        if (i == len - 1) {
            return true;
        } else {

            return false;
        }
    }
}
// @lc code=end

