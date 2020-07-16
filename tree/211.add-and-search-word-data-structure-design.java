import java.util.TreeMap;

/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */

// @lc code=start
class WordDictionary {

    /** Initialize your data structure here. */
    class Node{
        boolean isWord;
        TreeMap<Character, Node> nexts;
        Node(){
            nexts = new TreeMap<>();
        }
    }
    Node root;
    int size;
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for(char c: word.toCharArray()){
            if(cur.nexts.get(c) == null)
                cur.nexts.put(c, new Node());
            cur = cur.nexts.get(c);
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchAt(word, 0, root);
    }
    // // 0, 1 -1
    // private boolean searchAt(String word, int pos, Node cur){
    //     if(pos == word.length())
    //         return cur.isWord;
      
    //     char c = word.charAt(pos);
    //     // if(c!='.')
    //     //     if(cur.nexts.get(c) == null)
    //     //         return false;
    //     //     else
    //     //         return searchAt(word, pos+1, cur.nexts.get(c));
    //     if(c == '.'){
    //         if(pos == word.length() - 1)
    //             return true;
    //         for(int i=0; i<26; i++){
    //             char curChar =  (char)('a' + i);
    //             if(searchAt(word, pos+1, cur.nexts.get(curChar)))
    //                 return true;
    //         }
    //         return false;
    //     }
    //     return searchAt(word, pos+1, cur.nexts.get(c));
    // }  

    // 0, 1 -1
    private boolean searchAt(String word, int pos, Node cur) {
        if (pos == word.length())
            return cur.isWord;

        char c = word.charAt(pos);
        if(c != '.'){
            if(cur.nexts.get(c) == null)
                return false;
            else
             return searchAt(word, pos+1, cur.nexts.get(c));
        }
        //这里是 keyset 而不是 26 个字母遍历 就是说到了这个点往下找到了的如果是 null 是不可以的
        for(char nextChar: cur.nexts.keySet()){
            if (searchAt(word, pos + 1, cur.nexts.get(nextChar)))
                return true;
        }
        //  for(int i=0; i<26; i++){
        //         char curChar =  (char)('a' + i);
        //         if(searchAt(word, pos+1, cur.nexts.get(curChar)))
        //             return true;
        //     }
        return false;   
    }
    public static void main(String[] args) {
         WordDictionary obj = new WordDictionary(); 
         obj.addWord("bad"); 
         obj.addWord("dad"); 
         obj.addWord("mad"); 
         System.out.println(obj.search("pad")); 
         obj.search("bad"); 
         obj.search(".ad"); 
         obj.search("b.."); 
         //??怎么能避免这些错误呢
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

