/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        String str2 = str.trim();

        // StringBuilder active = new StringBuilder();
        int res = 0;

        int isNegative = 1;
        // System.out.println(str2.toCharArray());
        char[] arr = str2.toCharArray();
        // Java.lang.ArrayIndexOutOfBoundsException
        if(arr.length == 0)
            return 0;

        int index = 0;
        if(arr[index] == '-' || arr[index] == '+'){
        
            if(arr[index] == '-') isNegative = -1;
            index++;
        }
        for(;index<arr.length;index++){
            char c = arr[index];
            if(Character.isDigit(c)){
                // detect overflow??
                if (res > (Integer.MAX_VALUE - (c - '0')) / 10) { //Detect the integer overflow.
                    res = (isNegative == -1)? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    return res;
                }
                res =  res * 10 + (c-'0');
            }else  
                break;
        }

        return res * isNegative;
        
    }
}
// @lc code=end

