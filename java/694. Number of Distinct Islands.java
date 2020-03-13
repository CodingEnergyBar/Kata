import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1268 lang=java
 *
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

*   Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
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

