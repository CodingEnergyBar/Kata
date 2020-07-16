import java.util.TreeMap;

/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 */

// @lc code=start
class MapSum {

    class Node{
        int value;
        boolean isWord;
        TreeMap<Character, Node> nexts;
        Node(){
            nexts = new TreeMap<>();
        }
    }
    Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();   
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        for(char c: key.toCharArray()){
            if(cur.nexts.get(c) == null)
                cur.nexts.put(c, new Node());
            cur = cur.nexts.get(c);
        }
        cur.isWord = true;
        cur.value = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.nexts.get(c) == null)
                return 0;
            cur = cur.nexts.get(c);
        }
        return sum(cur);
        // cur  root->a->p->p
    }
    private int sum(Node cur){
        //cur == null的情况不会被算进去
        // 甚至也不用再这里做 empty 的判断, 因为程序下面如果为零的话 不会进入循环
        if(cur.nexts.isEmpty()){
            return cur.value;
        }
        int res = 0;
        //isWord 在 path 上 也要被加进去
        if(cur.isWord == true)
            res += cur.value;
            // for 循环包装了不会回有 cur == null 被包含进去
        for(char next: cur.nexts.keySet()){
            res += sum(cur.nexts.get(next));
        }
        return res;
    }
    public static void main(String[] args) {
        MapSum obj = new MapSum(); 
         obj.insert("apple", 3);
         obj.insert("app", 2);
         System.out.println(obj.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

