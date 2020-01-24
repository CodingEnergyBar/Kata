public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        HashMap<Character, Integer> map = new HashMap();
        for (char a : s.toCharArray()) {
            int value = (int) map.getOrDefault(a, 0);
            map.put(a, value + 1);
        }

        int res = 0;
        boolean singleFlag = false;
        for (Map.Entry m : map.entrySet()) {
            int value = (int) m.getValue();
            if (value % 2 == 1 && singleFlag == false) {
                res += 1;
                singleFlag = true;
            }
            res += (value / 2) * 2;
        }
        return res;
    }
}