import java.util.ArrayList;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    Node root;
    int size;
    class Node{
        boolean isWord;
        TreeMap<Character, Node> nexts;
       
        Node(){
            isWord = false;
            nexts = new TreeMap<>();
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(char c: word.toCharArray()){
            if(cur.nexts.get(c) == null){
                cur.nexts.put(c, new Node());
            }
            cur = cur.nexts.get(c);
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.nexts.get(c) == null) {
                return false;
            }
            cur = cur.nexts.get(c);
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.nexts.get(c) == null) {
                return false;
            }
            cur = cur.nexts.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

