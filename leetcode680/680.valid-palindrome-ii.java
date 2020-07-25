package leetcode680;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;
        List<Integer> list = isValidPlindrome(s, i, j);
        if(list == null)
            return true;
        return isValidPlindrome(s, list.get(0) + 1, list.get(1)) == null || 
        isValidPlindrome(s, list.get(0), list.get(1) - 1) == null;
    }
    // -1 is not, non -1 is the one for 
    List<Integer> isValidPlindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                List<Integer> res =  new ArrayList<>();
                res.add(start);
                res.add(end);
                return res;
            }
            start++;
            end--;
        }
        return null;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.validPalindrome("abc"));
        
    }
}
// @lc code=end

