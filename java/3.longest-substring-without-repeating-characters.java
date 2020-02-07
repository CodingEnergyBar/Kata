/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

//sliding window
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() ==0)
            return 0;
        int[] hash = new int[256];
        int i=0, j=0;
        int res=0;
        //[...i...j)
        // for(; i<s.length();i++){
        //     char cur = s.charAt(i);
        //     for(;j<s.length()&& hash[s.charAt(j)] == 0;j++){
        //         hash[s.charAt(j)] = 1;
        //     }
        //     hash[cur] = 0;
        //     res = Math.max(res, j-i);
        // }
while(j<s.length()){
    char end = s.charAt(j);
    if(hash[end] == 1){
        
        hash[s.charAt(i)] = 0;
        i++;
    }else{
        // 这里 不停的更新, 而不是上面 [i...j] 均满足条件
        res = Math.max(res, j-i+1);
            hash[end] = 1;
            j++;
    }
}
return res;
    }
}
// @lc code=end

