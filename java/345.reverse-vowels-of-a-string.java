import java.util.ArrayList;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        int vNum = 0;
        char[] charArr = s.toCharArray();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (isVowel(cur)) {
                arr[vNum++] = i;
            }
        }

        for (int i = 0, j = vNum - 1; i < j; i++, j--) {
            swap(arr[i], arr[j], charArr);
        }
        return String.valueOf(charArr);
        // return String.join(arr[i], "");
    }

    void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    boolean isVowel(char a) {
        return "aiueoAIUEO".indexOf(a) != -1;
    }

    public static void main(String[] args) {
        // char 是单引号 string是双引号
        System.out.println(new Solution().reverseVowels("aA"));
        // System.out.println(("aiueo".indexOf('a')));
    }
}
// @lc code=end
