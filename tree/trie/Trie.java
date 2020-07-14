package trie;

import java.util.ArrayList;
import java.util.TreeMap;

class Node {
    Boolean isWord;
    TreeMap<Character, Node> nexts;

    Node() {
        isWord = false;
        nexts = new TreeMap<>();
    }
}
class Trie {
    Node root;
    int size;

    Trie(ArrayList<String> words){
        root =  new Node();
        size = 0;
    }
    int getSize(){
        return size;
    }
    void add(String word){
        Node cur = root;// root 是不代表什么的 表示的是空 null:next(a)->null:next(m)->isWord=true
        for(char w: word.toCharArray()){
            if(cur.nexts.get(w) == null)
                cur.nexts.put(w, new Node());
            // cur.nexts.put(w, new Node());  
            cur = cur.nexts.get(w);         
        }
        if(cur.isWord != true){
            size++;
            cur.isWord = true;
        }
    }

   
// root: a m_
     void add(Node cur, String word, int pos){
         char c = word.charAt(pos);
         if(pos == word.length()){
            if(cur.isWord == false){
                cur.isWord = true;
                size++;
            }
            return;
         }
         if(cur.nexts.get(c) == null)
            cur.nexts.put(c, new Node());
        add(cur.nexts.get(c), word, pos + 1);
     }

     Boolean contains(String word){
         Node cur = root;
         for(char a: word.toCharArray()){
             if(cur.nexts.get(a) == null)
                return false;
            cur = cur.nexts.get(a);
         }
         return cur.isWord;
     }

     Boolean isPrefix(String prefix){
         Node cur = root;
         for(char c: prefix.toCharArray()){
             if(cur.nexts.get(c) != null){
                 cur = cur.nexts.get(c);
             }
         }
         return cur.isWord;
     }
}


