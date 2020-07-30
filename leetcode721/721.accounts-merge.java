
package leetcode721;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // first name 
        // email + value(index)
        // add the first name  alist.get(0) name
        int size =  accounts.size();
        UF uf = new UF(size);
        //email to id
        Map<String, Integer> map = new HashMap<>();
   
        
        for(int i=0; i<size; i++){
            List<String> account = accounts.get(i);
            //email check
            for(int j=1; j<account.size();j++){
                String email = account.get(j);
                if(!map.containsKey(email)){
                    map.put(email, i);
                }else{
                    int k = map.get(email);
                    uf.union(i, k);
                }
            }
        }
        Map<Integer, TreeSet<String>> idEmails = new HashMap<>();
        // 整理外面
        for(int i=0; i<size; i++){
             List<String> account = accounts.get(i);
             TreeSet<String> emails;
            int parent =  uf.find(i);
            //这个逻辑还是要记住一下的
            if(!idEmails.containsKey(parent))
                idEmails.put(parent, new TreeSet<>());
            emails = idEmails.get(parent);
            
            List<String> list = account.subList(1, account.size());
            emails.addAll(list);
        }
        List<List<String>> res = new ArrayList<>();
        for(Integer id: idEmails.keySet()){
            String name = accounts.get(id).get(0);
            List<String> list = new ArrayList<>();
            list.add(name);
            for(String email: idEmails.get(id)){
                list.add(email);
            }
            res.add(list);

        }
        return res;
    }
    
    class UF{
        //id
        public int p[];
        UF(int size){
            p = new int[size];
            for(int i=0; i< size; i++)
                p[i] = i;
        }
        void union(int i, int j){
            int pi = find(i);
            int pj = find(j);
            if(pi != pj)
                p[pi] = pj;
        }
        //路径压缩能所有的压平吗?
        int find(int i){
            if(p[i] != i){
                p[i] = find(p[i]);
            }
            return p[i];
        }
        
        boolean isConnected(int i, int j){
            return find(i) == find(j);
        }

    }
    public static void main(String[] args) {
        // String[][] tmp = new String[][]{{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        String[][] tmp = new String[][]{{"David","David0@m.co","David1@m.co"},{"David","David3@m.co","David4@m.co"},{"David","David4@m.co","David5@m.co"},{"David","David2@m.co","David3@m.co"},{"David","David1@m.co","David2@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for(String[]t: tmp){
            //只有 arrays.aslist
            accounts.add( Arrays.asList(t));
            // accounts.add(new ArrayList<>(t));


        }
        Solution solution  = new Solution();
        solution.accountsMerge(accounts);
    }
}
// @lc code=end

