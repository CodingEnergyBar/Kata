public class Solution {
    /**
     * @param s: A string
     * @return: An integer
     */
    public int atoi(String s) {
        // write your code here
        s = s.trim();

        if (s == null || s.equals("")) {
            return 0;
        }

        // System.out.println(Arrays.toString(arr));

        // corner case the first char "+""-"
        // the float point
        // delete the none related

        // use sign instead of NEGATING
        long res = 0L;
        boolean isNegative = false;

        if (s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1);
            if (s.equals("")) {
                return 0;
            }
        }
        if (s.charAt(0) == '+') {
            s = s.substring(1);
            if (s.equals("")) {
                return 0;
            }
        }

        for (char ch : s.toCharArray()) {
            int cur = isDigit(ch);
            if (cur == -1) {
                return getResult(res, isNegative);
            }
            res = res * 10 + (long) cur;

            if (isBeyond(res)) {
                return getResult(res, isNegative);
            }
        }

        return getResult(res, isNegative);
    }

    int getResult(long res, boolean isNegative) {
        if (isNegative) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) res;
    }

    boolean isBeyond(long res) {
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE);
    }

    int isDigit(char ch) {
        return "0123456789".indexOf((int) ch);
    }
}