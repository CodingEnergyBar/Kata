/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {


    List<String> res;
    String[] hash = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
       
        res = new ArrayList<String>();

        //path stringbuilder???
        if(digits.length() == 0)
            return res;

        combo(digits, 0, new StringBuilder());

        return res;
   

    }

    // public StringBuilder deleteCharAt(int index)

    void combo(String digits, int index,  StringBuilder path){
        if(index == digits.length()){
            res.add(path.toString());
            return;
        }
        // "1".matches(regex)
        // if(!digits.charAt(index).matches("[1-9]"))
        char cur  =  digits.charAt(index);
        if(cur < '1' || cur > '9')
            return ;

        String charArr =  hash[cur - '1'];
        for(char a: charArr.toCharArray()){
            path.append(a);
            combo(digits, index+1, path);
            path.deleteCharAt(index);
        }
    }
 
}
// @lc code=end
