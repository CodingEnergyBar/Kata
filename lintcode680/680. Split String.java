package lintcode680;

import java.util.*;

class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
     
    
    public List<List<String>> splitString( String s) {
        List<List<String>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (s.length() == 0)
            return res;
        List<List<String>>[] dp = new ArrayList[2];
        // [0, 0)
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        List<String> first = new ArrayList<>();
        first.add(s.substring(0, 1));
        dp[1].add(first);

        for (int i = 2; i <= s.length(); i++) {
            String subString1 = s.substring(i - 1, i);
            String subString2 = s.substring(i - 2, i);
            dp[i % 2] = mergeList(getList(dp[((i + 1) % 2)], subString1), getList(dp[((i + 2) % 2)], subString2));
        }
        return dp[s.length() % 2];
        // write your code here
    }

    List<List<String>> getList(List<List<String>> pre, String cur) {
        if (pre.size() == 0)
            pre.add(new ArrayList<>());
        List<List<String>> res = new ArrayList<>();

        for (List<String> list : pre) {
            List<String> c = new ArrayList<>(list);
            c.add(cur);
            res.add(c);
        }
        return res;
    }

    List<List<String>> mergeList(List<List<String>> l1, List<List<String>> l2) {
        List<List<String>> res = new ArrayList<>(l1);
        res.addAll(l2);
        return res;
    }
    public static void main(String[] args) {
        // int[][] grid = new int[][]
        String s = "123";
        System.out.println(new Solution().splitString(s));

    }
}