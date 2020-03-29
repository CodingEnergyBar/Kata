import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
class Solution {
    class TrieNode{
        // Keep the product on the current node 
        List<String> data;
        TrieNode[] next;
        TrieNode(){
            data = new ArrayList<String>();
            next =  new TrieNode[26];
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //at most three product, lexicographically minimums products.
        
        //!!!
        Arrays.sort(products);

        TrieNode root = buildTrie(products);
        // trie 
        List<List<String>> res = new ArrayList<>();
        TrieNode p = root;
        char[] words =  searchWord.toCharArray();
        // root 肯定不为 null
        for(int i=0;i<words.length; i++){
            char c = words[i];
            int index = c - 'a';
            p = p.next[index]; // p
            
            if(p == null){
                for (int j = i; j < searchWord.length(); j++)
                    res.add(Collections.EMPTY_LIST);   
                return res;
            }
            res.add(p.data);
        }
        return res;
        
    }
       TrieNode buildTrie(String[] products){
        TrieNode root = new TrieNode(); 
        for(String product: products){
            TrieNode n = root;
            for(char c: product.toCharArray()){
                int i = c - 'a';
                if(n.next[i] == null){
                    n.next[i] = new TrieNode();
                }
                //这个顺序有些不好想
                n = n.next[i];
                if(n.data.size() < 3)
                    n.data.add(product);
            }
        }
          
         return root;
    }
  
}
// @lc code=end

