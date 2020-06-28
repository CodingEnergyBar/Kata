package leetcode301;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    
    List<Integer> leftList = new ArrayList<>();
    List<Integer> rightList = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int lRemovals = 0;
    List<Integer> leftRemovalList = new ArrayList<Integer>();

    int rRemovals = 0;
    char[] arr;
    int N;
    public List<String> removeInvalidParentheses(String s) {
        // find all "("
        arr = s.toCharArray();
        N = s.length();
        // find all ")"    
        findMinRemoval(s);
        dfs(rRemovals, lRemovals, this.arr, 0);
        return ans;
    }
    void dfs(int r, int l, char[] path, int start){
      if(l == 0 && r == 0){
          if(isValid(path)) ans.add(toValidString(path));
      }
    //   if(r > 0){
    //     for(int i=rStart; i< N; i++){
    //         if(path[i] == ')'){
    //             path[i] = 'a';
    //             while(path[rStart] == ')') rStart++;
    //             dfs(r-1, l, path, lStart, rStart);
    //             path[i] = ')';
    //         }
    //     }
    //   }
    //   for(int i = lStart; i < N;i++){
    //       if(path[i] == '('){
    //           path[i] = 'a';
    //           while (path[lStart] == '(') lStart++;
    //           dfs(r, l-1, path, lStart, rStart);
    //           path[i] = '(';
    //       }
    //   }
        for(int i = start; i < N; i++){
            if(i != start && path[i] == path[i-1]) continue;
            // ")" must be before "("
            char cur = path[i];
            if(r > 0 && path[i] == ')'){
                path[i] = '#';
                dfs(r-1, l, path, i+1);
                path[i] = cur;
            }else if(l > 0 && path[i] == '('){
                path[i] = '#';
                dfs(r, l-1, path, i+1);
                path[i] = cur;
            }
        }
    }
    
    private String toValidString(char[] arr) {
        StringBuilder res = new StringBuilder();
        for(char a: arr){
            if( a != '#')
                res.append(a);
        }
        return res.toString();
    }

    boolean isValid(char[] arr) {
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if (arr[i] == '(')  cnt++;
            else if (arr[i] == ')') cnt--;
            if(cnt < 0)
                return false;
        }
        return cnt == 0;
    }
    // remove all the ")" 
	private void findMinRemoval(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                // leftList.add(i);
                cnt++;
            }
            else if (s.charAt(i) == ')'){
                // rightList.add(i);
                if(cnt == 0){
                    // 变成无关代码
                    rRemovals++;
                }else if(cnt > 0){
                     cnt--;
                }
            }
        }
        lRemovals = cnt;
    }
    public static void main(String[] args) {
      List<String> ans =   new Solution().removeInvalidParentheses("()())()");
      System.out.println(ans.toString());
    }
  
}
// @lc code=end

