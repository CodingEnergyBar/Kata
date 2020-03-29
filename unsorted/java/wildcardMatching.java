public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */

    public boolean isMatch(String s, String p) {
        // write your code here
        Map<String, Boolean> memo = new HashMap();
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        return isMatchedFrom(S, 0, P, 0, memo);
    }

    boolean isMatchedFrom(char[] s, int i, char[] p, int j, Map memo) {
        if (i == s.length) {
            while (j < p.length && p[j] == '*')
                j++;
            if (j == p.length) {
                memo.put((i + "," + j), true);
                return true;
            } else {
                memo.put((i + "," + j), false);
                return false;
            }

        }

        if (j == p.length) {
            memo.put((i + "," + j), i == s.length);
            return i == s.length;
        }

        if (memo.containsKey(i + "," + j)) {

            // System.out.println("memo " + memo.toString());
            return (boolean) memo.get(i + "," + j);
        }

        // match need to tracked so, you have to have one return in the final
        // and track the match in the hashmap
        boolean match = false;

        if (p[j] != '*') {
            if (s[i] == p[j] || p[j] == '?') {
                match = isMatchedFrom(s, i + 1, p, j + 1, memo);
            } else {
                match = false;
            }
        }

        else
            match = isMatchedFrom(s, i + 1, p, j, memo) || isMatchedFrom(s, i, p, j + 1, memo);

        memo.put(i + "," + j, match);
        return match;

    }
}