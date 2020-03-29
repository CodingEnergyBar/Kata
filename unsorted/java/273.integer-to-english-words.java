/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class Solution {
    public String numberToWords(int num) {
        // 2^31 - 1.
        // 4(billion),294(million)967(thousand)295
        if (num == 0)
            return "Zero";

        String[] arr = new String[4];
        for (int i = 0; i < 4; i++) {
            int curPart = num % 1000;
            arr[i] = translate(curPart);
            num = num / 1000;
        }
        String[] connections = { "", "Thousand", "Million", "Billion" };

        StringBuilder res = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            if (arr[i] != null && arr[i].length() != 0) {
                if (res.length() != 0)
                    res.append(" ");
                res.append(arr[i]);
                if (i != 0) {
                    res.append(" ");
                    res.append(connections[i]);
                }
            }
        }
        return res.toString();
    }

    String translate(int num) {
        // num <1000
        String[] bitsArray = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
        String[] tensArray = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        String[] basicBitsArray = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
        StringBuilder res = new StringBuilder();
        int hundredPlace = num / 100;
        if (hundredPlace != 0) {
            res.append(bitsArray[hundredPlace]);
            res.append(" Hundred");
            num = num - hundredPlace * 100;
        }
        int tensPlace = num / 10;
        if (tensPlace >= 2) {
            if (res.length() != 0)
                res.append(" ");
            res.append(tensArray[tensPlace]);

            num = num - tensPlace * 10;
        }
        if (num != 0) {
            if (res.length() != 0)
                res.append(" ");
            res.append(basicBitsArray[num]);
        }
        return res.toString();
    }
}
// @lc code=end
