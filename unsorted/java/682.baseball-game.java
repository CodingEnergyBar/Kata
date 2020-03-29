/*
 * @lc app=leetcode id=682 lang=java
 *
 * [682] Baseball Game
 */

// @lc code=start
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> scores = new Stack<>();
        for(String cur: ops){
            if(cur.matches("-?\\d+")){
               
                int point = Integer.parseInt(cur);
                // System.out.println(point);
                scores.push(point);
            }else{
                if(cur.equals("+")){
                    int last = scores.pop();
                    int secondLast = scores.pop();

                    int point = last+ secondLast;
                    scores.push(secondLast);
                    scores.push(last);
                  
                    scores.push(point);
                }else if(cur.equals("D")){
                    scores.push(scores.peek() * 2);
                }else if(cur.equals("C")){
                    scores.pop();
                }
            }
        }
        int sum = 0;
        while(!scores.isEmpty()){
            sum+=scores.pop();
        }
        return sum;
        
    }
}
// @lc code=end

