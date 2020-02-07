/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I',             1);
            put('V',             5);
            put('X',             10);
            put('L',             50);
            put('C',             100);
            put('D',             500);
            put('M',             1000);
        }};
        int res = 0, len=s.length();
        for(int i =0; i< len;i++){
            char cur = s.charAt(i);
            assert(map.containsKey(cur));
            int num = map.get(cur);
            if(i+1<len){
                char next = s.charAt(i+1);
                assert(map.containsKey(next));
                if(num < map.get(next))
                    num = -num;
            }
            res+= num;
            
            
        }
        return res;

        
    }
}
// @lc code=end

